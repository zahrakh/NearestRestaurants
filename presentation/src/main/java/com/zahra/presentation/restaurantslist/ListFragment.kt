package com.zahra.presentation.restaurantslist

import android.Manifest
import android.content.res.Configuration
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.MultiplePermissionsState
import com.google.accompanist.permissions.PermissionsRequired
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.zahra.domain.data.Restaurant
import com.zahra.presentation.R
import com.zahra.presentation.restaurantslist.screen.LocationDialogScreen
import com.zahra.presentation.restaurantslist.screen.RestaurantListScreen
import com.zahra.presentation.ui.component.Button
import com.zahra.presentation.ui.component.ErrorView
import com.zahra.presentation.ui.component.ProgressView
import com.zahra.presentation.ui.shape.TextFieldBackground
import com.zahra.presentation.ui.theme.NearestRestaurantsTheme
import com.zahra.presentation.ui.theme.OrangeColor

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun RestaurantsListScreen(
    modifier: Modifier = Modifier,
    viewModel: ListViewModel = hiltViewModel(),
    onClickToDetailScreen: (Restaurant) -> Unit = {},
) {
    val context = LocalContext.current

    LaunchedEffect(key1 = Unit) {
        viewModel.getRestaurantByPostCode()
    }

    val screenState by viewModel.state.collectAsStateWithLifecycle()
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val multiplePermissionState = rememberMultiplePermissionsState(
        permissions = listOf(
            Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION
        )
    )

    Surface(
        modifier = modifier.fillMaxSize(), color = MaterialTheme.colors.background
    ) {
        Scaffold(
            modifier = modifier,
            scaffoldState = scaffoldState,
            topBar = {
                ScreenAppBar()
            },
        ) { innerPadding ->
            Column(
                modifier = Modifier.padding(innerPadding),
            ) {
                LocationPinScreen(screenState.currentPostCode,
                    openDialog = { viewModel.showGoneDialogLocation(true) },
                    requestForGPS = {
                        if (multiplePermissionState.allPermissionsGranted) {
                            viewModel.searchByGPS(context)
                        } else {
                            multiplePermissionState.launchMultiplePermissionRequest()
                            viewModel.requestForPermission(true)
                        }
                    }
                )
                if (!screenState.restaurantList.isNullOrEmpty()) {
                    RestaurantListScreen(
                        modifier = Modifier,
                        restaurantList = screenState.restaurantList,
                        onClickToDetailScreen = onClickToDetailScreen,
                    )
                }
                ProgressView(
                    screenState.isLoading
                )
                ErrorView(
                    errorMessage = screenState.errorMessage ?: "",
                    ocClick = { viewModel.onRetry() },
                    visible = screenState.errorMessage != null,
                )
                if (screenState.showDialogLocation) LocationDialogScreen(
                    value = screenState.currentPostCode,
                    setShowDialog = {
                        viewModel.showGoneDialogLocation(it)
                    }) {
                    viewModel.getRestaurantByPostCode(it)
                }
                if (screenState.showLocationRequest) {
                    viewModel.requestForPermission(false)
                    LocationPermissions(
                        multiplePermissionState,
                        onGrant = { viewModel.searchByGPS(context = context) }
                    )
                }
            }
        }
    }
}

@Composable
private fun ScreenAppBar() {
    TopAppBar(
        title = { Text(stringResource(R.string.page_title)) },
        backgroundColor = MaterialTheme.colors.background,
        navigationIcon = {
            Icon(
                imageVector = Icons.Default.Home,
                modifier = Modifier.padding(horizontal = 4.dp),
                contentDescription = "Action icon",
                tint = OrangeColor
            )
        },
    )
}

@Composable
private fun LocationPinScreen(
    locationPostCode: String,
    requestForGPS: () -> Unit,
    openDialog: () -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .height(60.dp)
            .border(
                width = 1.dp, brush = TextFieldBackground, shape = RoundedCornerShape(4.dp)
            ),
        verticalAlignment = Alignment.CenterVertically,

        ) {
        Button(
            text = stringResource(id = R.string.search_by_gps), onClick = requestForGPS
        )
        Icon(
            imageVector = Icons.Default.ArrowDropDown,
            modifier = Modifier.padding(horizontal = 4.dp),
            contentDescription = stringResource(id = R.string.find_location),
            tint = Color.Gray
        )
        Text(
            text = stringResource(
                id = R.string.find_location, locationPostCode
            ),
            color = Color.Gray,

            modifier = Modifier.clickable {
                openDialog()
            },
        )
    }
}


@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun LocationPermissions(
    multiplePermissionState: MultiplePermissionsState,
    onGrant: () -> Unit
) {
    PermissionsRequired(
        multiplePermissionsState = multiplePermissionState,
        permissionsNotGrantedContent = { /* ... */ },
        permissionsNotAvailableContent = { /* ... */ }
    ) {
        onGrant()
    }
}


@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun HomeFragmentPreview() {
    NearestRestaurantsTheme {
        RestaurantsListScreen()
    }
}



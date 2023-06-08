package com.zahra.presentation.viewmodel

import com.zahra.domain.data.Either
import com.zahra.domain.data.Restaurant
import com.zahra.domain.di.DispatcherProvider
import com.zahra.domain.usecase.GetRestaurantsByLocationUseCase
import com.zahra.domain.usecase.GetRestaurantsByPostCodeUseCase
import com.zahra.presentation.restaurantslist.ListViewModel
import com.zahra.presentation.util.MainDispatcherRule
import com.zahra.presentation.utils.DEFAULT_POST_CODE
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.stub

@RunWith(MockitoJUnitRunner::class)
class ListViewModelTest {

    private var postCodeUseCase: GetRestaurantsByPostCodeUseCase = mock()
    private var locationUseCase: GetRestaurantsByLocationUseCase = mock()
    private lateinit var mockDispatcher: DispatcherProvider
    private lateinit var listViewModel: ListViewModel

    @OptIn(ExperimentalCoroutinesApi::class)
    val unconfinedDispatcher = UnconfinedTestDispatcher()

    @get:Rule
    val rule = MainDispatcherRule()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp() {
        Dispatchers.setMain(unconfinedDispatcher)
        MockitoAnnotations.openMocks(this)
        mockDispatcher = object : DispatcherProvider {
            override fun io() = unconfinedDispatcher
            override fun main() = unconfinedDispatcher
            override fun default() = unconfinedDispatcher
            override fun unconfined() = unconfinedDispatcher
        }
        listViewModel = ListViewModel(postCodeUseCase, locationUseCase, mockDispatcher)
    }


    @Test
    fun `test get restaurants by postCode and check is Open`() = runTest {
        postCodeUseCase.stub {
            onBlocking {
                invoke(DEFAULT_POST_CODE)
            }.doReturn(
                Either.Success<ArrayList<Restaurant>?, String>(
                    arrayListOf(
                        Restaurant(
                            id = 1,
                            name = "SHILA",
                            logoUrl = "https://shilaLogoUrl.gif",
                            isOpen = true,
                            rate = 1.0f,
                            cuisineTypes = null,
                        )
                    )
                )
            )
        }

        listViewModel.getRestaurantByPostCode(postCode = DEFAULT_POST_CODE)
        val isOpen = listViewModel.state.value.restaurantList?.get(0)?.isOpen ?: false
        Assert.assertEquals(true, isOpen)
    }


    @Test
    fun `test get restaurants by Location and check result`() = runTest {
        locationUseCase.stub {
            onBlocking {
                invoke(0.0,0.0)
            }.doReturn(
                Either.Success<ArrayList<Restaurant>?, String>(
                    arrayListOf(
                        Restaurant(
                            id = 1,
                            name = "Parla Pizza",
                            logoUrl = "https://shilaLogoUrl.gif",
                            isOpen = true,
                            rate = 2.9f,
                            cuisineTypes = null,
                        )
                    )
                )
            )
        }

        listViewModel.getRestaurantByLocation(0.0,0.0)
        val name = listViewModel.state.value.restaurantList?.get(0)?.name
        Assert.assertEquals("Parla Pizza", name)
    }

}
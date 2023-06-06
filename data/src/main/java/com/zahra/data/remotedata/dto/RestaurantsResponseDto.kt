package com.zahra.data.remotedata.dto

import com.google.gson.annotations.SerializedName


data class RestaurantsResponseDto(
    @SerializedName("Area"              ) val area              : String?                       = null,
    @SerializedName("MetaData"          ) val metaData          : MetaDataDto?                  = null,
    @SerializedName("Restaurants"       ) val restaurants       : List<RestaurantsDto>?         = null,
    @SerializedName("ShortResultText"   ) val shortResultText   : String?                       = null,
    @SerializedName("deliveryFees"      ) val deliveryFees      : DeliveryFeesDto?              = null,
    @SerializedName("promotedPlacement" ) val promotedPlacement : PromotedPlacementDto?         = null,
    @SerializedName("RestaurantSets"    ) val restaurantSets    : List<RestaurantSetsDto>?      = null,
    @SerializedName("CuisineSets"       ) val cuisineSets       : List<CuisineSetsDto>?         = null,
    @SerializedName("Views"             ) val views             : List<ViewsDto>?               = null,
    @SerializedName("Dishes"            ) val dishes            : List<String>?                 = null
)

 
data class MetaDataDto (
    @SerializedName("CanonicalName"                             ) val canonicalName:String? = null,
    @SerializedName("District"                                  ) val district:String? = null,
    @SerializedName("Postcode"                                  ) val postcode:String? = null,
    @SerializedName("Area"                                      ) val area:String? = null,
    @SerializedName("Latitude"                                  ) val latitude:Double?=null,
    @SerializedName("Longitude"                                 ) val longitude:Double?= null,
    @SerializedName("CuisineDetails"                            ) val cuisineDetails:List<CuisineDetailsDto>? = null,
    @SerializedName("ResultCount"                               ) val resultCount:Int?= null,
    @SerializedName("SearchedTerms"                             ) val searchedTerms:String?= null,
    @SerializedName("TagDetails"                                ) val tagDetails: List<TagDetailsDto>? = null,
    @SerializedName("CollectionExperimentInjectedRestaurantIds" ) val collectionExperimentInjectedRestaurantIds : String?                   = null,
    @SerializedName("DeliveryArea"                              ) val deliveryArea:String?= null
)

 
data class RestaurantsDto (
    @SerializedName("Id"                          ) val id                          : Int?                     = null,
    @SerializedName("Name"                        ) val name                        : String?                  = null,
    @SerializedName("UniqueName"                  ) val uniqueName                  : String?                  = null,
    @SerializedName("Address"                     ) val address                     : AddressDto?              = null,
    @SerializedName("City"                        ) val city                        : String?                  = null,
    @SerializedName("Postcode"                    ) val postcode                    : String?                  = null,
    @SerializedName("Latitude"                    ) val latitude                    : Double?                  = null,
    @SerializedName("Longitude"                   ) val longitude                   : Double?                  = null,
    @SerializedName("Rating"                      ) val rating                      : RatingDto?               = null,
    @SerializedName("RatingStars"                 ) val ratingStars                 : Double?                  = null,
    @SerializedName("NumberOfRatings"             ) val numberOfRatings             : Int?                     = null,
    @SerializedName("RatingAverage"               ) val ratingAverage               : Double?                  = null,
    @SerializedName("Description"                 ) val description                 : String?                  = null,
    @SerializedName("Url"                         ) val url                         : String?                  = null,
    @SerializedName("LogoUrl"                     ) val logoUrl                     : String?                  = null,
    @SerializedName("IsTestRestaurant"            ) val isTestRestaurant            : Boolean?                 = null,
    @SerializedName("IsHalal"                     ) val isHalal                     : Boolean?                 = null,
    @SerializedName("IsNew"                       ) val isNew                       : Boolean?                 = null,
    @SerializedName("ReasonWhyTemporarilyOffline" ) val reasonWhyTemporarilyOffline : String?                  = null,
    @SerializedName("DriveDistance"               ) val driveDistance               : Double?                  = null,
    @SerializedName("DriveInfoCalculated"         ) val driveInfoCalculated         : Boolean?                 = null,
    @SerializedName("IsCloseBy"                   ) val isCloseBy                   : Boolean?                 = null,
    @SerializedName("OfferPercent"                ) val offerPercent                : Double?                  = null,
    @SerializedName("NewnessDate"                 ) val newnessDate                 : String?                  = null,
    @SerializedName("OpeningTime"                 ) val openingTime                 : String?                  = null,
    @SerializedName("OpeningTimeUtc"              ) val openingTimeUtc              : String?                  = null,
    @SerializedName("OpeningTimeIso"              ) val openingTimeIso              : String?                  = null,
    @SerializedName("OpeningTimeLocal"            ) val openingTimeLocal            : String?                  = null,
    @SerializedName("DeliveryOpeningTimeLocal"    ) val deliveryOpeningTimeLocal    : String?                  = null,
    @SerializedName("DeliveryOpeningTime"         ) val deliveryOpeningTime         : String?                  = null,
    @SerializedName("DeliveryOpeningTimeUtc"      ) val deliveryOpeningTimeUtc      : String?                  = null,
    @SerializedName("DeliveryStartTime"           ) val deliveryStartTime           : String?                  = null,
    @SerializedName("DeliveryTime"                ) val deliveryTime                : String?                  = null,
    @SerializedName("DeliveryTimeMinutes"         ) val deliveryTimeMinutes         : String?                  = null,
    @SerializedName("DeliveryWorkingTimeMinutes"  ) val deliveryWorkingTimeMinutes  : Int?                     = null,
    @SerializedName("DeliveryEtaMinutes"          ) val deliveryEtaMinutes          : DeliveryEtaMinutesDto?    = null,
    @SerializedName("IsCollection"                ) val isCollection                : Boolean?                 = null,
    @SerializedName("IsDelivery"                  ) val isDelivery                  : Boolean?                 = null,
    @SerializedName("IsFreeDelivery"              ) val isFreeDelivery              : Boolean?                 = null,
    @SerializedName("IsOpenNowForCollection"      ) val isOpenNowForCollection      : Boolean?                 = null,
    @SerializedName("IsOpenNowForDelivery"        ) val isOpenNowForDelivery        : Boolean?                 = null,
    @SerializedName("IsOpenNowForPreorder"        ) val isOpenNowForPreorder        : Boolean?                 = null,
    @SerializedName("IsOpenNow"                   ) val isOpenNow                   : Boolean?                 = null,
    @SerializedName("IsTemporarilyOffline"        ) val isTemporarilyOffline        : Boolean?                 = null,
    @SerializedName("DeliveryMenuId"              ) val deliveryMenuId              : String?                  = null,
    @SerializedName("CollectionMenuId"            ) val collectionMenuId            : String?                  = null,
    @SerializedName("DeliveryZipcode"             ) val deliveryZipcode             : String?                  = null,
    @SerializedName("DeliveryCost"                ) val deliveryCost                : Double?                  = null,
    @SerializedName("MinimumDeliveryValue"        ) val minimumDeliveryValue        : Double?                  = null,
    @SerializedName("SecondDateRanking"           ) val secondDateRanking           : Double?                  = null,
    @SerializedName("DefaultDisplayRank"          ) val defaultDisplayRank          : Int?                     = null,
    @SerializedName("SponsoredPosition"           ) val sponsoredPosition           : Int?                     = null,
    @SerializedName("SecondDateRank"              ) val secondDateRank              : Double?                  = null,
    @SerializedName("Score"                       ) val score                       : Double?                  = null,
    @SerializedName("IsTemporaryBoost"            ) val isTemporaryBoost            : Boolean?                 = null,
    @SerializedName("IsSponsored"                 ) val isSponsored                 : Boolean?                 = null,
    @SerializedName("IsPremier"                   ) val isPremier                   : Boolean?                 = null,
    @SerializedName("HygieneRating"               ) val hygieneRating               : String?                  = null,
    @SerializedName("ShowSmiley"                  ) val showSmiley                  : Boolean?                 = null,
    @SerializedName("SmileyDate"                  ) val smileyDate                  : String?                  = null,
    @SerializedName("SmileyElite"                 ) val smileyElite                 : Boolean?                 = null,
    @SerializedName("SmileyResult"                ) val smileyResult                : String?                  = null,
    @SerializedName("SmileyUrl"                   ) val smileyUrl                   : String?                  = null,
    @SerializedName("SendsOnItsWayNotifications"  ) val sendsOnItsWayNotifications  : Boolean?                 = null,
    @SerializedName("BrandName"                   ) val brandName                   : String?                  = null,
    @SerializedName("IsBrand"                     ) val isBrand                     : Boolean?                 = null,
    @SerializedName("LastUpdated"                 ) val lastUpdated                 : String?                  = null,
    @SerializedName("Deals"                       ) val deals                       : List<String>?             =null,
    @SerializedName("Offers"                      ) val offers                      : List<String>?             =null,
    @SerializedName("Logo"                        ) val logo                        : List<LogoDto>?            =null,
    @SerializedName("Tags"                        ) val tags                        : List<String>?             =null,
    @SerializedName("DeliveryChargeBands"         ) val deliveryChargeBands         : List<String>?             =null,
    @SerializedName("CuisineTypes"                ) val cuisineTypes                : List<CuisineTypesDto>?    =null,
    @SerializedName("Cuisines"                    ) val cuisines                    : List<CuisinesDto>?        =null,
    @SerializedName("ScoreMetaData"               ) val scoreMetaData               : List<ScoreMetaDataDto>?   =null,
    @SerializedName("Badges"                      ) val badges                      : List<String>?             =null,
    @SerializedName("OpeningTimes"                ) val openingTimes                : List<String>?             =null,
    @SerializedName("ServiceableAreas"            ) val serviceableAreas            : List<String>?             =null
)

 
data class DeliveryEtaMinutesDto (
    @SerializedName("Approximate" ) val approximate : String? = null,
    @SerializedName("RangeLower"  ) val rangeLower  : Int?    = null,
    @SerializedName("RangeUpper"  ) val rangeUpper  : Int?    = null
)

 
data class ScoreMetaDataDto (
    @SerializedName("Key"   ) val key   : String? = null,
    @SerializedName("Value" ) val value : String? = null
)

 
data class LogoDto (
    @SerializedName("StandardResolutionURL" ) val standardResolutionURL : String? = null
)

 
data class CuisineTypesDto(
    @SerializedName("Id"           ) val id           : Int?     = null,
    @SerializedName("IsTopCuisine" ) val isTopCuisine : Boolean? = null,
    @SerializedName("Name"         ) val name         : String?  = null,
    @SerializedName("SeoName"      ) val seoName      : String?  = null
)

 
data class AddressDto (
    @SerializedName("City"      ) val city      : String? = null,
    @SerializedName("FirstLine" ) val firstLine : String? = null,
    @SerializedName("Postcode"  ) val postcode  : String? = null,
    @SerializedName("Latitude"  ) val latitude  : Double? = null,
    @SerializedName("Longitude" ) val longitude : Double? = null
)

 
data class RatingDto (
    @SerializedName("Count"      ) val count      : Int?    = null,
    @SerializedName("Average"    ) val average    : Double? = null,
    @SerializedName("StarRating" ) val starRating : Double? = null
)

 
data class ViewsDto (
    @SerializedName("Target"     ) val target     : String?               = null,
    @SerializedName("Components" ) val components : List<ComponentsDto>? = null
)

 
data class ViewDataDto (
    @SerializedName("Title"              ) val title              : String?             = null,
    @SerializedName("SubTitle"           ) val subTitle           : String?             = null,
    @SerializedName("SeeAllSearchTarget" ) val seeAllSearchTarget : SeeAllSearchTargetDto? = null,
    @SerializedName("SeeAllFilterId"     ) val seeAllFilterId     : String?             = null,
    @SerializedName("FocusedProperties"  ) val focusedProperties  : List<String>?       = null,
    @SerializedName("Dishes"             ) val dishes             : String?             = null
)

 
data class SeeAllSearchTargetDto (
    @SerializedName("CuisineFilters" ) val cuisineFilters : List<String>? = null,
    @SerializedName("SortOrder"      ) val sortOrder      : String?           = null,
    @SerializedName("Refinements"    ) val refinements    : List<String>? = null
)

 
data class ComponentsDto (
    @SerializedName("Type"         ) val type         : String?   = null,
    @SerializedName("Id"           ) val id           : String?   = null,
    @SerializedName("TrackingId"   ) val trackingId   : String?   = null,
    @SerializedName("TemplateName" ) val templateName : String?   = null,
    @SerializedName("ViewData"     ) val viewData     : ViewDataDto? = null
)

 
data class CuisineSetsDto (
    @SerializedName("Id"       ) val Id       : String?             = null,
    @SerializedName("Name"     ) val Name     : String?             = null,
    @SerializedName("Type"     ) val Type     : String?             = null,
    @SerializedName("Cuisines" ) val Cuisines : List<CuisinesDto>?  = null
)

 
data class CuisinesDto (
    @SerializedName("Name"    ) val Name    : String? = null,
    @SerializedName("SeoName" ) val SeoName : String? = null
)

 
data class PromotedPlacementDto (
    @SerializedName("filteredSearchPromotedLimit" ) val filteredSearchPromotedLimit : Int?        = null,
    @SerializedName("rankedIds"                   ) val rankedIds                   : List<Int>?  = null,
    @SerializedName("restaurants"                 ) val PromotedRestaurantsMap                 : HashMap<Int, PromotedRestaurantsDto>?   = hashMapOf()
)

 
data class PromotedRestaurantsDto(
   @SerializedName("restaurantId"    ) val restaurantId    : String?  = null,
   @SerializedName("defaultPromoted" ) val defaultPromoted : Boolean? = null
)

 
data class RestaurantSetsDto (
    @SerializedName("Id"          ) val id          : String?                = null,
    @SerializedName("Name"        ) val name        : String?                = null,
    @SerializedName("Type"        ) val type        : String?                = null,
 )

 
data class CuisineDetailsDto (
    @SerializedName("Name"    ) val name    : String? = null,
    @SerializedName("SeoName" ) val seoName : String? = null,
    @SerializedName("Total"   ) val total   : Int?    = null
)

 
data class TagDetailsDto (
    @SerializedName("BackgroundColour" ) val backgroundColour : String? = null,
    @SerializedName("Colour"           ) val colour           : String? = null,
    @SerializedName("DisplayName"      ) val displayName      : String? = null,
    @SerializedName("Key"              ) val key              : String? = null,
    @SerializedName("Priority"         ) val priority         : Int?    = null
)

 
data class DeliveryFeesDto (
    @SerializedName("restaurants" ) val restaurants : HashMap<Int, RestaurantsFeeDto>? = null
)

 
data class RestaurantsFeeDto(
    @SerializedName("restaurantId"      ) val restaurantId      : String?          = null,
    @SerializedName("minimumOrderValue" ) val minimumOrderValue : Int?             = null,
    @SerializedName("bands"             ) val bands             : List<BandsDto>?  = null
)

 
data class BandsDto (
    @SerializedName("minimumAmount" ) val minimumAmount : Int? = null,
    @SerializedName("fee"           ) val fee           : Int? = null
)
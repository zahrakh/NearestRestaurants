package com.zahra.data.remote.dto

import com.google.gson.annotations.SerializedName


data class RestaurantsResponseDto(
    @SerializedName("Area"              ) var Area              : String?                      = null,
    @SerializedName("MetaData"          ) var MetaData          : MetaDataDto?                 = null,
    @SerializedName("Restaurants"       ) var Restaurants       : ArrayList<RestaurantsDto>    = arrayListOf(),
    @SerializedName("ShortResultText"   ) var ShortResultText   : String?                      = null,
    @SerializedName("deliveryFees"      ) var deliveryFees      : DeliveryFeesDto?             = null,
    @SerializedName("promotedPlacement" ) var promotedPlacement : PromotedPlacementDto?        = null,
    @SerializedName("RestaurantSets"    ) var RestaurantSets    : ArrayList<RestaurantSetsDto> = arrayListOf(),
    @SerializedName("CuisineSets"       ) var CuisineSets       : ArrayList<CuisineSetsDto>    = arrayListOf(),
    @SerializedName("Views"             ) var Views             : ArrayList<ViewsDto>          = arrayListOf(),
    @SerializedName("Dishes"            ) var Dishes            : ArrayList<String>            = arrayListOf()
)

 
data class MetaDataDto (
    @SerializedName("CanonicalName"                             ) var CanonicalName:String? = null,
    @SerializedName("District"                                  ) var District:String? = null,
    @SerializedName("Postcode"                                  ) var Postcode:String? = null,
    @SerializedName("Area"                                      ) var Area:String? = null,
    @SerializedName("Latitude"                                  ) var Latitude:Double?=null,
    @SerializedName("Longitude"                                 ) var Longitude:Double?= null,
    @SerializedName("CuisineDetails"                            ) var CuisineDetails:ArrayList<CuisineDetailsDto> = arrayListOf(),
    @SerializedName("ResultCount"                               ) var ResultCount:Int?= null,
    @SerializedName("SearchedTerms"                             ) var SearchedTerms:String?= null,
    @SerializedName("TagDetails"                                ) var TagDetails: ArrayList<TagDetailsDto> = arrayListOf(),
    @SerializedName("CollectionExperimentInjectedRestaurantIds" ) var CollectionExperimentInjectedRestaurantIds : String?                   = null,
    @SerializedName("DeliveryArea"                              ) var DeliveryArea:String?= null
)

 
data class RestaurantsDto (
    @SerializedName("Id"                          ) var Id                          : Int?                     = null,
    @SerializedName("Name"                        ) var Name                        : String?                  = null,
    @SerializedName("UniqueName"                  ) var UniqueName                  : String?                  = null,
    @SerializedName("Address"                     ) var Address                     : AddressDto?                 = null,
    @SerializedName("City"                        ) var City                        : String?                  = null,
    @SerializedName("Postcode"                    ) var Postcode                    : String?                  = null,
    @SerializedName("Latitude"                    ) var Latitude                    : Double?                  = null,
    @SerializedName("Longitude"                   ) var Longitude                   : Double?                  = null,
    @SerializedName("Rating"                      ) var Rating                      : RatingDto?                  = null,
    @SerializedName("RatingStars"                 ) var RatingStars                 : Double?                  = null,
    @SerializedName("NumberOfRatings"             ) var NumberOfRatings             : Int?                     = null,
    @SerializedName("RatingAverage"               ) var RatingAverage               : Double?                  = null,
    @SerializedName("Description"                 ) var Description                 : String?                  = null,
    @SerializedName("Url"                         ) var Url                         : String?                  = null,
    @SerializedName("LogoUrl"                     ) var LogoUrl                     : String?                  = null,
    @SerializedName("IsTestRestaurant"            ) var IsTestRestaurant            : Boolean?                 = null,
    @SerializedName("IsHalal"                     ) var IsHalal                     : Boolean?                 = null,
    @SerializedName("IsNew"                       ) var IsNew                       : Boolean?                 = null,
    @SerializedName("ReasonWhyTemporarilyOffline" ) var ReasonWhyTemporarilyOffline : String?                  = null,
    @SerializedName("DriveDistance"               ) var DriveDistance               : Double?                  = null,
    @SerializedName("DriveInfoCalculated"         ) var DriveInfoCalculated         : Boolean?                 = null,
    @SerializedName("IsCloseBy"                   ) var IsCloseBy                   : Boolean?                 = null,
    @SerializedName("OfferPercent"                ) var OfferPercent                : Double?                  = null,
    @SerializedName("NewnessDate"                 ) var NewnessDate                 : String?                  = null,
    @SerializedName("OpeningTime"                 ) var OpeningTime                 : String?                  = null,
    @SerializedName("OpeningTimeUtc"              ) var OpeningTimeUtc              : String?                  = null,
    @SerializedName("OpeningTimeIso"              ) var OpeningTimeIso              : String?                  = null,
    @SerializedName("OpeningTimeLocal"            ) var OpeningTimeLocal            : String?                  = null,
    @SerializedName("DeliveryOpeningTimeLocal"    ) var DeliveryOpeningTimeLocal    : String?                  = null,
    @SerializedName("DeliveryOpeningTime"         ) var DeliveryOpeningTime         : String?                  = null,
    @SerializedName("DeliveryOpeningTimeUtc"      ) var DeliveryOpeningTimeUtc      : String?                  = null,
    @SerializedName("DeliveryStartTime"           ) var DeliveryStartTime           : String?                  = null,
    @SerializedName("DeliveryTime"                ) var DeliveryTime                : String?                  = null,
    @SerializedName("DeliveryTimeMinutes"         ) var DeliveryTimeMinutes         : String?                  = null,
    @SerializedName("DeliveryWorkingTimeMinutes"  ) var DeliveryWorkingTimeMinutes  : Int?                     = null,
    @SerializedName("DeliveryEtaMinutes"          ) var DeliveryEtaMinutes          : DeliveryEtaMinutesDto?      = null,
    @SerializedName("IsCollection"                ) var IsCollection                : Boolean?                 = null,
    @SerializedName("IsDelivery"                  ) var IsDelivery                  : Boolean?                 = null,
    @SerializedName("IsFreeDelivery"              ) var IsFreeDelivery              : Boolean?                 = null,
    @SerializedName("IsOpenNowForCollection"      ) var IsOpenNowForCollection      : Boolean?                 = null,
    @SerializedName("IsOpenNowForDelivery"        ) var IsOpenNowForDelivery        : Boolean?                 = null,
    @SerializedName("IsOpenNowForPreorder"        ) var IsOpenNowForPreorder        : Boolean?                 = null,
    @SerializedName("IsOpenNow"                   ) var IsOpenNow                   : Boolean?                 = null,
    @SerializedName("IsTemporarilyOffline"        ) var IsTemporarilyOffline        : Boolean?                 = null,
    @SerializedName("DeliveryMenuId"              ) var DeliveryMenuId              : String?                  = null,
    @SerializedName("CollectionMenuId"            ) var CollectionMenuId            : String?                  = null,
    @SerializedName("DeliveryZipcode"             ) var DeliveryZipcode             : String?                  = null,
    @SerializedName("DeliveryCost"                ) var DeliveryCost                : Double?                  = null,
    @SerializedName("MinimumDeliveryValue"        ) var MinimumDeliveryValue        : Double?                  = null,
    @SerializedName("SecondDateRanking"           ) var SecondDateRanking           : Double?                  = null,
    @SerializedName("DefaultDisplayRank"          ) var DefaultDisplayRank          : Int?                     = null,
    @SerializedName("SponsoredPosition"           ) var SponsoredPosition           : Int?                     = null,
    @SerializedName("SecondDateRank"              ) var SecondDateRank              : Double?                  = null,
    @SerializedName("Score"                       ) var Score                       : Double?                  = null,
    @SerializedName("IsTemporaryBoost"            ) var IsTemporaryBoost            : Boolean?                 = null,
    @SerializedName("IsSponsored"                 ) var IsSponsored                 : Boolean?                 = null,
    @SerializedName("IsPremier"                   ) var IsPremier                   : Boolean?                 = null,
    @SerializedName("HygieneRating"               ) var HygieneRating               : String?                  = null,
    @SerializedName("ShowSmiley"                  ) var ShowSmiley                  : Boolean?                 = null,
    @SerializedName("SmileyDate"                  ) var SmileyDate                  : String?                  = null,
    @SerializedName("SmileyElite"                 ) var SmileyElite                 : Boolean?                 = null,
    @SerializedName("SmileyResult"                ) var SmileyResult                : String?                  = null,
    @SerializedName("SmileyUrl"                   ) var SmileyUrl                   : String?                  = null,
    @SerializedName("SendsOnItsWayNotifications"  ) var SendsOnItsWayNotifications  : Boolean?                 = null,
    @SerializedName("BrandName"                   ) var BrandName                   : String?                  = null,
    @SerializedName("IsBrand"                     ) var IsBrand                     : Boolean?                 = null,
    @SerializedName("LastUpdated"                 ) var LastUpdated                 : String?                  = null,
    @SerializedName("Deals"                       ) var Deals                       : ArrayList<String>        = arrayListOf(),
    @SerializedName("Offers"                      ) var Offers                      : ArrayList<String>        = arrayListOf(),
    @SerializedName("Logo"                        ) var Logo                        : ArrayList<LogoDto>          = arrayListOf(),
    @SerializedName("Tags"                        ) var Tags                        : ArrayList<String>        = arrayListOf(),
    @SerializedName("DeliveryChargeBands"         ) var DeliveryChargeBands         : ArrayList<String>        = arrayListOf(),
    @SerializedName("CuisineTypes"                ) var CuisineTypes                : ArrayList<CuisineTypesDto>  = arrayListOf(),
    @SerializedName("Cuisines"                    ) var Cuisines                    : ArrayList<CuisinesDto>      = arrayListOf(),
    @SerializedName("ScoreMetaData"               ) var ScoreMetaData               : ArrayList<ScoreMetaDataDto> = arrayListOf(),
    @SerializedName("Badges"                      ) var Badges                      : ArrayList<String>        = arrayListOf(),
    @SerializedName("OpeningTimes"                ) var OpeningTimes                : ArrayList<String>        = arrayListOf(),
    @SerializedName("ServiceableAreas"            ) var ServiceableAreas            : ArrayList<String>        = arrayListOf()
)

 
data class DeliveryEtaMinutesDto (
    @SerializedName("Approximate" ) var Approximate : String? = null,
    @SerializedName("RangeLower"  ) var RangeLower  : Int?    = null,
    @SerializedName("RangeUpper"  ) var RangeUpper  : Int?    = null
)

 
data class ScoreMetaDataDto (
    @SerializedName("Key"   ) var Key   : String? = null,
    @SerializedName("Value" ) var Value : String? = null
)

 
data class LogoDto (
    @SerializedName("StandardResolutionURL" ) var StandardResolutionURL : String? = null
)

 
data class CuisineTypesDto(
    @SerializedName("Id"           ) var Id           : Int?     = null,
    @SerializedName("IsTopCuisine" ) var IsTopCuisine : Boolean? = null,
    @SerializedName("Name"         ) var Name         : String?  = null,
    @SerializedName("SeoName"      ) var SeoName      : String?  = null
)

 
data class AddressDto (
    @SerializedName("City"      ) var City      : String? = null,
    @SerializedName("FirstLine" ) var FirstLine : String? = null,
    @SerializedName("Postcode"  ) var Postcode  : String? = null,
    @SerializedName("Latitude"  ) var Latitude  : Double? = null,
    @SerializedName("Longitude" ) var Longitude : Double? = null
)

 
data class RatingDto (
    @SerializedName("Count"      ) var Count      : Int?    = null,
    @SerializedName("Average"    ) var Average    : Double? = null,
    @SerializedName("StarRating" ) var StarRating : Double? = null
)

 
data class ViewsDto (
    @SerializedName("Target"     ) var Target     : String?               = null,
    @SerializedName("Components" ) var Components : ArrayList<ComponentsDto> = arrayListOf()
)

 
data class ViewDataDto (
    @SerializedName("Title"              ) var Title              : String?             = null,
    @SerializedName("SubTitle"           ) var SubTitle           : String?             = null,
    @SerializedName("SeeAllSearchTarget" ) var SeeAllSearchTarget : SeeAllSearchTargetDto? = null,
    @SerializedName("SeeAllFilterId"     ) var SeeAllFilterId     : String?             = null,
    @SerializedName("FocusedProperties"  ) var FocusedProperties  : ArrayList<String>   = arrayListOf(),
    @SerializedName("Dishes"             ) var Dishes             : String?             = null
)

 
data class SeeAllSearchTargetDto (
    @SerializedName("CuisineFilters" ) var CuisineFilters : ArrayList<String> = arrayListOf(),
    @SerializedName("SortOrder"      ) var SortOrder      : String?           = null,
    @SerializedName("Refinements"    ) var Refinements    : ArrayList<String> = arrayListOf()
)

 
data class ComponentsDto (
    @SerializedName("Type"         ) var Type         : String?   = null,
    @SerializedName("Id"           ) var Id           : String?   = null,
    @SerializedName("TrackingId"   ) var TrackingId   : String?   = null,
    @SerializedName("TemplateName" ) var TemplateName : String?   = null,
    @SerializedName("ViewData"     ) var ViewData     : ViewDataDto? = null
)

 
data class CuisineSetsDto (
    @SerializedName("Id"       ) var Id       : String?             = null,
    @SerializedName("Name"     ) var Name     : String?             = null,
    @SerializedName("Type"     ) var Type     : String?             = null,
    @SerializedName("Cuisines" ) var Cuisines : ArrayList<CuisinesDto> = arrayListOf()
)

 
data class CuisinesDto (
    @SerializedName("Name"    ) var Name    : String? = null,
    @SerializedName("SeoName" ) var SeoName : String? = null
)

 
data class PromotedPlacementDto (
    @SerializedName("filteredSearchPromotedLimit" ) var filteredSearchPromotedLimit : Int?           = null,
    @SerializedName("rankedIds"                   ) var rankedIds                   : ArrayList<Int> = arrayListOf(),
    @SerializedName("restaurants"                 ) var PromotedRestaurantsMap                 : HashMap<Int, PromotedRestaurantsDto>?   = hashMapOf()
)

 
data class PromotedRestaurantsDto(
   @SerializedName("restaurantId"    ) var restaurantId    : String?  = null,
   @SerializedName("defaultPromoted" ) var defaultPromoted : Boolean? = null
)

 
data class RestaurantSetsDto (
    @SerializedName("Id"          ) var Id          : String?                = null,
    @SerializedName("Name"        ) var Name        : String?                = null,
    @SerializedName("Type"        ) var Type        : String?                = null,
 )

 
data class CuisineDetailsDto (
    @SerializedName("Name"    ) var Name    : String? = null,
    @SerializedName("SeoName" ) var SeoName : String? = null,
    @SerializedName("Total"   ) var Total   : Int?    = null
)

 
data class TagDetailsDto (
    @SerializedName("BackgroundColour" ) var BackgroundColour : String? = null,
    @SerializedName("Colour"           ) var Colour           : String? = null,
    @SerializedName("DisplayName"      ) var DisplayName      : String? = null,
    @SerializedName("Key"              ) var Key              : String? = null,
    @SerializedName("Priority"         ) var Priority         : Int?    = null
)

 
data class DeliveryFeesDto (
    @SerializedName("restaurants" ) var restaurants : HashMap<Int, RestaurantsFeeDto>? = null
)

 
data class RestaurantsFeeDto(
    @SerializedName("restaurantId"      ) var restaurantId      : String?          = null,
    @SerializedName("minimumOrderValue" ) var minimumOrderValue : Int?             = null,
    @SerializedName("bands"             ) var bands             : ArrayList<BandsDto> = arrayListOf()
)

 
data class BandsDto (
    @SerializedName("minimumAmount" ) var minimumAmount : Int? = null,
    @SerializedName("fee"           ) var fee           : Int? = null
)
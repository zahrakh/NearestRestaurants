package com.zahra.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RestaurantsResponseDto(
    @SerialName("Area"              ) var Area              : String?                      = null,
    @SerialName("MetaData"          ) var MetaData          : MetaDataDto?                 = null,
    @SerialName("Restaurants"       ) var Restaurants       : ArrayList<RestaurantsDto>    = arrayListOf(),
    @SerialName("ShortResultText"   ) var ShortResultText   : String?                      = null,
    @SerialName("deliveryFees"      ) var deliveryFees      : DeliveryFeesDto?             = null,
    @SerialName("promotedPlacement" ) var promotedPlacement : PromotedPlacementDto?        = null,
    @SerialName("RestaurantSets"    ) var RestaurantSets    : ArrayList<RestaurantSetsDto> = arrayListOf(),
    @SerialName("CuisineSets"       ) var CuisineSets       : ArrayList<CuisineSetsDto>    = arrayListOf(),
    @SerialName("Views"             ) var Views             : ArrayList<ViewsDto>          = arrayListOf(),
    @SerialName("Dishes"            ) var Dishes            : ArrayList<String>            = arrayListOf()
)

@Serializable
data class MetaDataDto (
    @SerialName("CanonicalName"                             ) var CanonicalName:String? = null,
    @SerialName("District"                                  ) var District:String? = null,
    @SerialName("Postcode"                                  ) var Postcode:String? = null,
    @SerialName("Area"                                      ) var Area:String? = null,
    @SerialName("Latitude"                                  ) var Latitude:Double?=null,
    @SerialName("Longitude"                                 ) var Longitude:Double?= null,
    @SerialName("CuisineDetails"                            ) var CuisineDetails:ArrayList<CuisineDetailsDto> = arrayListOf(),
    @SerialName("ResultCount"                               ) var ResultCount:Int?= null,
    @SerialName("SearchedTerms"                             ) var SearchedTerms:String?= null,
    @SerialName("TagDetails"                                ) var TagDetails: ArrayList<TagDetailsDto> = arrayListOf(),
    @SerialName("CollectionExperimentInjectedRestaurantIds" ) var CollectionExperimentInjectedRestaurantIds : String?                   = null,
    @SerialName("DeliveryArea"                              ) var DeliveryArea:String?= null
)

@Serializable
data class RestaurantsDto (
    @SerialName("Id"                          ) var Id                          : Int?                     = null,
    @SerialName("Name"                        ) var Name                        : String?                  = null,
    @SerialName("UniqueName"                  ) var UniqueName                  : String?                  = null,
    @SerialName("Address"                     ) var Address                     : AddressDto?                 = null,
    @SerialName("City"                        ) var City                        : String?                  = null,
    @SerialName("Postcode"                    ) var Postcode                    : String?                  = null,
    @SerialName("Latitude"                    ) var Latitude                    : Double?                  = null,
    @SerialName("Longitude"                   ) var Longitude                   : Double?                  = null,
    @SerialName("Rating"                      ) var Rating                      : RatingDto?                  = null,
    @SerialName("RatingStars"                 ) var RatingStars                 : Double?                  = null,
    @SerialName("NumberOfRatings"             ) var NumberOfRatings             : Int?                     = null,
    @SerialName("RatingAverage"               ) var RatingAverage               : Double?                  = null,
    @SerialName("Description"                 ) var Description                 : String?                  = null,
    @SerialName("Url"                         ) var Url                         : String?                  = null,
    @SerialName("LogoUrl"                     ) var LogoUrl                     : String?                  = null,
    @SerialName("IsTestRestaurant"            ) var IsTestRestaurant            : Boolean?                 = null,
    @SerialName("IsHalal"                     ) var IsHalal                     : Boolean?                 = null,
    @SerialName("IsNew"                       ) var IsNew                       : Boolean?                 = null,
    @SerialName("ReasonWhyTemporarilyOffline" ) var ReasonWhyTemporarilyOffline : String?                  = null,
    @SerialName("DriveDistance"               ) var DriveDistance               : Double?                  = null,
    @SerialName("DriveInfoCalculated"         ) var DriveInfoCalculated         : Boolean?                 = null,
    @SerialName("IsCloseBy"                   ) var IsCloseBy                   : Boolean?                 = null,
    @SerialName("OfferPercent"                ) var OfferPercent                : Double?                  = null,
    @SerialName("NewnessDate"                 ) var NewnessDate                 : String?                  = null,
    @SerialName("OpeningTime"                 ) var OpeningTime                 : String?                  = null,
    @SerialName("OpeningTimeUtc"              ) var OpeningTimeUtc              : String?                  = null,
    @SerialName("OpeningTimeIso"              ) var OpeningTimeIso              : String?                  = null,
    @SerialName("OpeningTimeLocal"            ) var OpeningTimeLocal            : String?                  = null,
    @SerialName("DeliveryOpeningTimeLocal"    ) var DeliveryOpeningTimeLocal    : String?                  = null,
    @SerialName("DeliveryOpeningTime"         ) var DeliveryOpeningTime         : String?                  = null,
    @SerialName("DeliveryOpeningTimeUtc"      ) var DeliveryOpeningTimeUtc      : String?                  = null,
    @SerialName("DeliveryStartTime"           ) var DeliveryStartTime           : String?                  = null,
    @SerialName("DeliveryTime"                ) var DeliveryTime                : String?                  = null,
    @SerialName("DeliveryTimeMinutes"         ) var DeliveryTimeMinutes         : String?                  = null,
    @SerialName("DeliveryWorkingTimeMinutes"  ) var DeliveryWorkingTimeMinutes  : Int?                     = null,
    @SerialName("DeliveryEtaMinutes"          ) var DeliveryEtaMinutes          : DeliveryEtaMinutesDto?      = null,
    @SerialName("IsCollection"                ) var IsCollection                : Boolean?                 = null,
    @SerialName("IsDelivery"                  ) var IsDelivery                  : Boolean?                 = null,
    @SerialName("IsFreeDelivery"              ) var IsFreeDelivery              : Boolean?                 = null,
    @SerialName("IsOpenNowForCollection"      ) var IsOpenNowForCollection      : Boolean?                 = null,
    @SerialName("IsOpenNowForDelivery"        ) var IsOpenNowForDelivery        : Boolean?                 = null,
    @SerialName("IsOpenNowForPreorder"        ) var IsOpenNowForPreorder        : Boolean?                 = null,
    @SerialName("IsOpenNow"                   ) var IsOpenNow                   : Boolean?                 = null,
    @SerialName("IsTemporarilyOffline"        ) var IsTemporarilyOffline        : Boolean?                 = null,
    @SerialName("DeliveryMenuId"              ) var DeliveryMenuId              : String?                  = null,
    @SerialName("CollectionMenuId"            ) var CollectionMenuId            : String?                  = null,
    @SerialName("DeliveryZipcode"             ) var DeliveryZipcode             : String?                  = null,
    @SerialName("DeliveryCost"                ) var DeliveryCost                : Double?                  = null,
    @SerialName("MinimumDeliveryValue"        ) var MinimumDeliveryValue        : Double?                  = null,
    @SerialName("SecondDateRanking"           ) var SecondDateRanking           : Double?                  = null,
    @SerialName("DefaultDisplayRank"          ) var DefaultDisplayRank          : Int?                     = null,
    @SerialName("SponsoredPosition"           ) var SponsoredPosition           : Int?                     = null,
    @SerialName("SecondDateRank"              ) var SecondDateRank              : Double?                  = null,
    @SerialName("Score"                       ) var Score                       : Double?                  = null,
    @SerialName("IsTemporaryBoost"            ) var IsTemporaryBoost            : Boolean?                 = null,
    @SerialName("IsSponsored"                 ) var IsSponsored                 : Boolean?                 = null,
    @SerialName("IsPremier"                   ) var IsPremier                   : Boolean?                 = null,
    @SerialName("HygieneRating"               ) var HygieneRating               : String?                  = null,
    @SerialName("ShowSmiley"                  ) var ShowSmiley                  : Boolean?                 = null,
    @SerialName("SmileyDate"                  ) var SmileyDate                  : String?                  = null,
    @SerialName("SmileyElite"                 ) var SmileyElite                 : Boolean?                 = null,
    @SerialName("SmileyResult"                ) var SmileyResult                : String?                  = null,
    @SerialName("SmileyUrl"                   ) var SmileyUrl                   : String?                  = null,
    @SerialName("SendsOnItsWayNotifications"  ) var SendsOnItsWayNotifications  : Boolean?                 = null,
    @SerialName("BrandName"                   ) var BrandName                   : String?                  = null,
    @SerialName("IsBrand"                     ) var IsBrand                     : Boolean?                 = null,
    @SerialName("LastUpdated"                 ) var LastUpdated                 : String?                  = null,
    @SerialName("Deals"                       ) var Deals                       : ArrayList<String>        = arrayListOf(),
    @SerialName("Offers"                      ) var Offers                      : ArrayList<String>        = arrayListOf(),
    @SerialName("Logo"                        ) var Logo                        : ArrayList<LogoDto>          = arrayListOf(),
    @SerialName("Tags"                        ) var Tags                        : ArrayList<String>        = arrayListOf(),
    @SerialName("DeliveryChargeBands"         ) var DeliveryChargeBands         : ArrayList<String>        = arrayListOf(),
    @SerialName("CuisineTypes"                ) var CuisineTypes                : ArrayList<CuisineTypesDto>  = arrayListOf(),
    @SerialName("Cuisines"                    ) var Cuisines                    : ArrayList<CuisinesDto>      = arrayListOf(),
    @SerialName("ScoreMetaData"               ) var ScoreMetaData               : ArrayList<ScoreMetaDataDto> = arrayListOf(),
    @SerialName("Badges"                      ) var Badges                      : ArrayList<String>        = arrayListOf(),
    @SerialName("OpeningTimes"                ) var OpeningTimes                : ArrayList<String>        = arrayListOf(),
    @SerialName("ServiceableAreas"            ) var ServiceableAreas            : ArrayList<String>        = arrayListOf()
)

@Serializable
data class DeliveryEtaMinutesDto (
    @SerialName("Approximate" ) var Approximate : String? = null,
    @SerialName("RangeLower"  ) var RangeLower  : Int?    = null,
    @SerialName("RangeUpper"  ) var RangeUpper  : Int?    = null
)

@Serializable
data class ScoreMetaDataDto (
    @SerialName("Key"   ) var Key   : String? = null,
    @SerialName("Value" ) var Value : String? = null
)

@Serializable
data class LogoDto (
    @SerialName("StandardResolutionURL" ) var StandardResolutionURL : String? = null
)

@Serializable
data class CuisineTypesDto(
    @SerialName("Id"           ) var Id           : Int?     = null,
    @SerialName("IsTopCuisine" ) var IsTopCuisine : Boolean? = null,
    @SerialName("Name"         ) var Name         : String?  = null,
    @SerialName("SeoName"      ) var SeoName      : String?  = null
)

@Serializable
data class AddressDto (
    @SerialName("City"      ) var City      : String? = null,
    @SerialName("FirstLine" ) var FirstLine : String? = null,
    @SerialName("Postcode"  ) var Postcode  : String? = null,
    @SerialName("Latitude"  ) var Latitude  : Double? = null,
    @SerialName("Longitude" ) var Longitude : Double? = null
)

@Serializable
data class RatingDto (
    @SerialName("Count"      ) var Count      : Int?    = null,
    @SerialName("Average"    ) var Average    : Double? = null,
    @SerialName("StarRating" ) var StarRating : Double? = null
)

@Serializable
data class ViewsDto (
    @SerialName("Target"     ) var Target     : String?               = null,
    @SerialName("Components" ) var Components : ArrayList<ComponentsDto> = arrayListOf()
)

@Serializable
data class ViewDataDto (
    @SerialName("Title"              ) var Title              : String?             = null,
    @SerialName("SubTitle"           ) var SubTitle           : String?             = null,
    @SerialName("SeeAllSearchTarget" ) var SeeAllSearchTarget : SeeAllSearchTargetDto? = null,
    @SerialName("SeeAllFilterId"     ) var SeeAllFilterId     : String?             = null,
    @SerialName("FocusedProperties"  ) var FocusedProperties  : ArrayList<String>   = arrayListOf(),
    @SerialName("Dishes"             ) var Dishes             : String?             = null
)

@Serializable
data class SeeAllSearchTargetDto (
    @SerialName("CuisineFilters" ) var CuisineFilters : ArrayList<String> = arrayListOf(),
    @SerialName("SortOrder"      ) var SortOrder      : String?           = null,
    @SerialName("Refinements"    ) var Refinements    : ArrayList<String> = arrayListOf()
)

@Serializable
data class ComponentsDto (
    @SerialName("Type"         ) var Type         : String?   = null,
    @SerialName("Id"           ) var Id           : String?   = null,
    @SerialName("TrackingId"   ) var TrackingId   : String?   = null,
    @SerialName("TemplateName" ) var TemplateName : String?   = null,
    @SerialName("ViewData"     ) var ViewData     : ViewDataDto? = null
)

@Serializable
data class CuisineSetsDto (
    @SerialName("Id"       ) var Id       : String?             = null,
    @SerialName("Name"     ) var Name     : String?             = null,
    @SerialName("Type"     ) var Type     : String?             = null,
    @SerialName("Cuisines" ) var Cuisines : ArrayList<CuisinesDto> = arrayListOf()
)

@Serializable
data class CuisinesDto (
    @SerialName("Name"    ) var Name    : String? = null,
    @SerialName("SeoName" ) var SeoName : String? = null
)

@Serializable
data class PromotedPlacementDto (
    @SerialName("filteredSearchPromotedLimit" ) var filteredSearchPromotedLimit : Int?           = null,
    @SerialName("rankedIds"                   ) var rankedIds                   : ArrayList<Int> = arrayListOf(),
    @SerialName("restaurants"                 ) var PromotedRestaurantsMap                 : HashMap<Int, PromotedRestaurantsDto>?   = hashMapOf()
)

@Serializable
data class PromotedRestaurantsDto(
   @SerialName("restaurantId"    ) var restaurantId    : String?  = null,
   @SerialName("defaultPromoted" ) var defaultPromoted : Boolean? = null
)

@Serializable
data class RestaurantSetsDto (
    @SerialName("Id"          ) var Id          : String?                = null,
    @SerialName("Name"        ) var Name        : String?                = null,
    @SerialName("Type"        ) var Type        : String?                = null,
 )

@Serializable
data class CuisineDetailsDto (
    @SerialName("Name"    ) var Name    : String? = null,
    @SerialName("SeoName" ) var SeoName : String? = null,
    @SerialName("Total"   ) var Total   : Int?    = null
)

@Serializable
data class TagDetailsDto (
    @SerialName("BackgroundColour" ) var BackgroundColour : String? = null,
    @SerialName("Colour"           ) var Colour           : String? = null,
    @SerialName("DisplayName"      ) var DisplayName      : String? = null,
    @SerialName("Key"              ) var Key              : String? = null,
    @SerialName("Priority"         ) var Priority         : Int?    = null
)

@Serializable
data class DeliveryFeesDto (
    @SerialName("restaurants" ) var restaurants : HashMap<Int, RestaurantsFeeDto>? = null
)

@Serializable
data class RestaurantsFeeDto(
    @SerialName("restaurantId"      ) var restaurantId      : String?          = null,
    @SerialName("minimumOrderValue" ) var minimumOrderValue : Int?             = null,
    @SerialName("bands"             ) var bands             : ArrayList<BandsDto> = arrayListOf()
)

@Serializable
data class BandsDto (
    @SerialName("minimumAmount" ) var minimumAmount : Int? = null,
    @SerialName("fee"           ) var fee           : Int? = null
)
using Newtonsoft.Json;

namespace RestSharpDataDriven.DataTypes
{
    public class Place
    {
        [JsonProperty("place name")]
        public string PlaceName { get; set; }
        [JsonProperty("longitude")]
        public string Longitude { get; set; }
        [JsonProperty("state")]
        public string State { get; set; }
        [JsonProperty("state abbreviation")]
        public string StateAbbreviation { get; set; }
        [JsonProperty("latitude")]
        public string Latitude { get; set; }
    }
}

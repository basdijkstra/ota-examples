using NUnit.Framework;
using RestSharp;
using RestSharp.Serialization.Json;
using RestSharpDataDriven.DataTypes;

namespace RestSharpDataDriven
{
    [TestFixture]
    public class DataDrivenUsingAttributesTests
    {
        private const string BASE_URL = "http://api.zippopotam.us";

        [TestCase("us", "90210", "Beverly Hills", TestName = "Check that US zipcode 90210 yields Beverly Hills")]
        [TestCase("us", "12345", "Schenectady", TestName = "Check that US zipcode 12345 yields Schenectady")]
        [TestCase("ca", "Y1A", "Whitehorse", TestName = "Check that CA zipcode Y1A yields Whitehorse")]
        public void RetrieveDataFor_ShouldYield
            (string countryCode, string zipCode, string expectedPlaceName)
        {
            // arrange
            RestClient client = new RestClient(BASE_URL);
            RestRequest request =
                new RestRequest($"{countryCode}/{zipCode}", Method.GET);

            // act
            IRestResponse response = client.Execute(request);
            LocationResponse locationResponse =
                new JsonDeserializer().
                Deserialize<LocationResponse>(response);

            // assert
            Assert.That(
                locationResponse.Places[0].PlaceName,
                Is.EqualTo(expectedPlaceName)
            );
        }
    }
}

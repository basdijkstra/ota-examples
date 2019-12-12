using NUnit.Framework;
using RestSharp;
using RestSharp.Serialization.Json;
using RestSharpDataDriven.DataTypes;

namespace RestSharpDataDriven
{
    [TestFixture]
    public class NonDataDrivenTests
    {
        private const string BASE_URL = "http://api.zippopotam.us";

        [Test]
        public void RetrieveDataForUs90210_ShouldYieldBeverlyHills()
        {
            // arrange
            RestClient client = new RestClient(BASE_URL);
            RestRequest request = 
                new RestRequest("us/90210", Method.GET);

            // act
            IRestResponse response = client.Execute(request);
            LocationResponse locationResponse =
                new JsonDeserializer().
                Deserialize<LocationResponse>(response);

            // assert
            Assert.That(
                locationResponse.Places[0].PlaceName,
                Is.EqualTo("Beverly Hills")
            );
        }

        [Test]
        public void RetrieveDataForUs12345_ShouldYieldSchenectady()
        {
            // arrange
            RestClient client = new RestClient(BASE_URL);
            RestRequest request =
                new RestRequest("us/12345", Method.GET);

            // act
            IRestResponse response = client.Execute(request);
            LocationResponse locationResponse =
                new JsonDeserializer().
                Deserialize<LocationResponse>(response);

            // assert
            Assert.That(
                locationResponse.Places[0].PlaceName,
                Is.EqualTo("Schenectady")
            );
        }

        [Test]
        public void RetrieveDataForCaY1A_ShouldYieldWhiteHorse()
        {
            // arrange
            RestClient client = new RestClient(BASE_URL);
            RestRequest request = 
                new RestRequest("ca/Y1A", Method.GET);

            // act
            IRestResponse response = client.Execute(request);
            LocationResponse locationResponse =
                new JsonDeserializer().
                Deserialize<LocationResponse>(response);

            // assert
            Assert.That(
                locationResponse.Places[0].PlaceName,
                Is.EqualTo("Whitehorse")
            );
        }
    }
}

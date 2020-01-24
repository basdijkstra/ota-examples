package golang_resty_examples

import (
	"encoding/json"
	"fmt"
	"github.com/go-resty/resty"
	"github.com/stretchr/testify/assert"
	"github.com/stretchr/testify/suite"
)

type ZippopotamUsTestSuite struct {
	suite.Suite
	ApiClient *resty.Client
}

func (suite *ZippopotamUsTestSuite) SetupTest() {
	suite.ApiClient = resty.New()
}

func (suite *ZippopotamUsTestSuite) Test_GetUs90210_StatusCodeShouldEqual200() {
	resp, _ := suite.ApiClient.R().Get("http://api.zippopotam.us/us/90210")

	assert.Equal(suite.T(), 200, resp.StatusCode())
}

func (suite *ZippopotamUsTestSuite) Test_GetUs90210_ContentTypeShouldEqualApplicationJson() {

	resp, _ := suite.ApiClient.R().Get("http://api.zippopotam.us/us/90210")

	assert.Equal(suite.T(), "application/json", resp.Header().Get("Content-Type"))
}

func (suite *ZippopotamUsTestSuite) Test_GetUs90210_CountryShouldEqualUnitedStates() {

	resp, _ := suite.ApiClient.R().Get("http://api.zippopotam.us/us/90210")

	myResponse := LocationResponse{}

	err := json.Unmarshal(resp.Body(), &myResponse)

	if err != nil {
		fmt.Println(err)
		return
	}

	assert.Equal(suite.T(), "United States", myResponse.Country)
}
package golang_resty_examples

import (
	"encoding/json"
	"fmt"
	"github.com/go-resty/resty"
	"github.com/stretchr/testify/assert"
	"testing"
)

func Test_GetUs90210_StatusCodeShouldEqual200(t *testing.T) {

	client := resty.New()

	resp, _ := client.R().Get("http://api.zippopotam.us/us/90210")

	assert.Equal(t, 200, resp.StatusCode())
}

func Test_GetUs90210_StatusCodeShouldEqual200_WithoutAssert(t *testing.T) {

	client := resty.New()

	resp, _ := client.R().Get("http://api.zippopotam.us/us/90210")

	if resp.StatusCode() != 200 {
		t.Errorf("Unexpected status code, expected %d, got %d instead", 200, resp.StatusCode())
	}
}

func Test_GetUs90210_ContentTypeShouldEqualApplicationJson(t *testing.T) {

	client := resty.New()

	resp, _ := client.R().Get("http://api.zippopotam.us/us/90210")

	assert.Equal(t, "application/json", resp.Header().Get("Content-Type"))
}

func Test_GetUs90210_CountryShouldEqualUnitedStates(t *testing.T) {

	client := resty.New()

	resp, _ := client.R().Get("http://api.zippopotam.us/us/90210")

	myResponse := LocationResponse{}

	err := json.Unmarshal(resp.Body(), &myResponse)

	if err != nil {
		fmt.Println(err)
		return
	}

	assert.Equal(t, "United States", myResponse.Country)
}


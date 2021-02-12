

var selCountry = document.getElementById("select_country")
var selState = document.getElementById("select_state")
var selCity = document.getElementById("select_city")


window.addEventListener('load', loadCountries);
function loadCountries() {

	var xhr = new XMLHttpRequest();
	xhr.open("GET", window.location.origin + "/rest/allCountries", true);

	xhr.onload = function() {
		if (this.status == 200) {

			var obj = JSON.parse(this.responseText);
			console.log("readyyyy")
			for (el of obj) {
				var node = document.createElement("OPTION");
				var textnode = document.createTextNode(el);
				node.appendChild(textnode);
				selCountry.appendChild(node)
			}


		}
	}
	xhr.send()

}


selCountry.addEventListener("change", loadStates)
function loadStates() {
	var country = selCountry.value

	console.log(country)

	var xhr = new XMLHttpRequest();
	xhr.open("GET", window.location.origin + "/rest/states?country=" + country, true);

	xhr.onload = function() {

		var obj = JSON.parse(this.responseText);
		selState.innerHTML = "";


		if (this.status == 200) {
			console.log(obj)
			for (el of obj) {
				var node = document.createElement("OPTION");
				var textnode = document.createTextNode(el);
				node.appendChild(textnode);
				selState.appendChild(node)
			}

		}
	}
	xhr.send()
}

selState.addEventListener("change", loadCities)
function loadCities() {
	var state = selState.value

	var xhr = new XMLHttpRequest();
	xhr.open("GET", window.location.origin + "/rest/cities?state=" + state, true);

	xhr.onload = function() {

		var obj = JSON.parse(this.responseText);

		if (this.status == 200) {
			selCity.innerHTML = "";
			console.log(obj)
			for (el of obj) {
				var node = document.createElement("OPTION");
				var textnode = document.createTextNode(el);
				node.appendChild(textnode);
				selCity.appendChild(node)
			}

		}
	}
	xhr.send()
}

# language: en
# namespace: Petstore
Feature: Petstore

Scenario: Név megadásával sikeresen létrehozható egy kisállat
POST /pet
	Given Petstore: egy kisállat neve "Zsömi"
	When Petstore: a megadott adatokkal létrehozok egy kisállatot
	Then Petstore: látom, hogy a kisállat létrejött

Scenario: Létező kisállat sikeresen törölhető
DELETE /pet/{petID}
	Given Petstore: van egy létező kisállat azonosítóm
	When Petstore: kitörlöm az adott kisállatot
	Then Petstore: látom, hogy a kisállat sikeresen törlődött

Scenario: Nem létező kisállat nem törölhető
DELETE /pet/{petID}
	Given Petstore: van egy nem létező kisállat azonosítóm
	When Petstore: kitörlöm az adott azonosítóhoz tartozó kisállatot
	Then Petstore: látom, hogy a kisállat nem létezik

Scenario: Létező kisállat adatai helyesen jelennek meg
GET /pet/{petID}
	Given Petstore: van egy létező kisállat a rendszerben
	When Petstore: lekérdezem az adott kisállat adatait
	Then Petstore: a lekérdezett adatok helyesen jelennek meg

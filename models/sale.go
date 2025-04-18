package models

import "time"

type Sale struct {
	Id       string
	SaleDate time.Time

	AddressId string
}

package models

import "github.com/shopspring/decimal"

type Product struct {
	Id          string
	Name        string
	Description string
	SalePrice   decimal.Decimal
	InStock     int32
}

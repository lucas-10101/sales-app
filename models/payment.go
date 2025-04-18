package models

import "github.com/shopspring/decimal"

type Payment struct {
	Id      string
	SaleId  string
	Ammount decimal.Decimal
}

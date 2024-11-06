# -*- coding: utf-8 -*-
"""
Created on Thu Jun  6 18:22:08 2024

@author: brand
"""
print('Welcome to software company')
print()

package = 99.00

b_amt = float(input("Quantity: "))

while b_amt < 0: 
    print('That is not a valid quantity. Please try again.\n')
    b_amt = float(input("Quantity: "))

if b_amt < 10:
    discount = 0.00
    subtotal = (b_amt * package)
    discount = subtotal * discount
    total = subtotal - discount
    print('Subtotal: ', format(subtotal, '.2f'))
    print('Discount: ', format(discount, '.2f'))
    print('Total: ', format(total, '.2f'))
elif b_amt >= 10 or b_amt <= 19:
    discount = 0.10
    subtotal = (b_amt * package)
    discount = subtotal * discount
    total = subtotal - discount
    print('Subtotal: ', format(subtotal, '.2f'))
    print('Discount: ', format(discount, '.2f'))
    print('Total: ', format(total, '.2f'))
elif b_amt >= 20 or b_amt <= 49:
    discount = 0.20
    subtotal = (b_amt * package)
    discount = subtotal * discount
    total = subtotal - discount
    print('Subtotal: ', format(subtotal, '.2f'))
    print('Discount: ', format(discount, '.2f'))
    print('Total: ', format(total, '.2f'))
elif b_amt >= 50 or b_amt <= 99:
    discount = 0.30
    subtotal = (b_amt * package)
    discount = subtotal * discount
    total = subtotal - discount
    print('Subtotal: ', format(subtotal, '.2f'))
    print('Discount: ', format(discount, '.2f'))
    print('Total: ', format(total, '.2f'))
elif b_amt >= 100:
    discount = 0.40
    subtotal = (b_amt * package)
    discount = subtotal * discount
    total = subtotal - discount
    print('Subtotal: ', format(subtotal, '.2f'))
    print('Discount: ', format(discount, '.2f'))
    print('Total: ', format(total, '.2f'))
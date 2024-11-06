# -*- coding: utf-8 -*-
"""
Created on Thu Jun  6 18:22:08 2024

@author: brand
"""
print('Welcome to software company')
print()

#setting package price as a float
package = 99.00

#initial question for getting amt customer wants to buy
print('How many packages would you like to buy?')
b_amt = float(input("Quantity: "))

#validation checking for anything below 0
while b_amt < 0: 
    print('That is not a valid quantity. Please try again.\n')
    b_amt = float(input("Quantity: "))

#calculation for amt below 10; 0% discount
if b_amt < 10:
    discount = 0.00
    subtotal = (b_amt * package)
    discount = subtotal * discount
    total = subtotal - discount
    print('Subtotal: ', format(subtotal, '.2f'))
    print('Discount: ', format(discount, '.2f'))
    print('Total: ', format(total, '.2f'))
#calculation for amt equal and between 10 and 19; 10% discount
elif b_amt >= 10 or b_amt <= 19:
    discount = 0.10
    subtotal = (b_amt * package)
    discount = subtotal * discount
    total = subtotal - discount
    print('Subtotal: ', format(subtotal, '.2f'))
    print('Discount: ', format(discount, '.2f'))
    print('Total: ', format(total, '.2f'))
#calculation for amt equal and between 20 and 49; 20% discount
elif b_amt >= 20 or b_amt <= 49:
    discount = 0.20
    subtotal = (b_amt * package)
    discount = subtotal * discount
    total = subtotal - discount
    print('Subtotal: ', format(subtotal, '.2f'))
    print('Discount: ', format(discount, '.2f'))
    print('Total: ', format(total, '.2f'))
#calculation for amt equal and between 50 and 99; 30% discount
elif b_amt >= 50 or b_amt <= 99:
    discount = 0.30
    subtotal = (b_amt * package)
    discount = subtotal * discount
    total = subtotal - discount
    print('Subtotal: ', format(subtotal, '.2f'))
    print('Discount: ', format(discount, '.2f'))
    print('Total: ', format(total, '.2f'))
#calculation for amt greater than or equal to 100; 40% discount
elif b_amt >= 100:
    discount = 0.40
    subtotal = (b_amt * package)
    discount = subtotal * discount
    total = subtotal - discount
    print('Subtotal: ', format(subtotal, '.2f'))
    print('Discount: ', format(discount, '.2f'))
    print('Total: ', format(total, '.2f'))
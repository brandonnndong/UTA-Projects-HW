# -*- coding: utf-8 -*-
"""
Created on Tues Jun 18 4:43:47 2024

@author: dong
"""

#main function
def main():
    #input from user
    scores = input("Enter five test scores separated by commas: ")
    #takes the input scores and separates them by the , to make them integers
    return [int(num) for num in scores.split(",")]

#function determine_grade that creates letter grade corresponding with input of number grades
def determine_grade(num):
    if 90 <= num <= 100:
        letter_grade = "A"
    elif 80 <= num <= 89:
        letter_grade = "B"
    elif 70 <= num <= 79:
        letter_grade = "C"
    elif 60 <= num <= 69:
        letter_grade = "D"
    else:
        letter_grade = "F"
    return letter_grade

#function calc_average
def calc_average(num):
    #divides the sum of the grade by the number of grades there are (len)
    avg = sum(num) / len(num)
    #giving the avg grade a letter grade
    grd = determine_grade(avg)
    #prints the avg and letter grade
    print("The average is: {:.1f} which is {}".format(avg, grd))

#a function to print the number grade and the letter grade
def show_letters(num, letter_grade):
    print("{:.1f} is {}\n".format(num, letter_grade))

#for loop to print all the corresponding number and letter grades
lst = main()
for n in lst:
    show_letters(n, determine_grade(n))
calc_average(lst)
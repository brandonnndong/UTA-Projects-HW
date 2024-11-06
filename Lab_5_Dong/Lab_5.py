# -*- coding: utf-8 -*-
"""
Created on Thurs July 18 6:45:38 2024

@author: dong
"""
from tkinter import messagebox
from tkinter import *
import math

class window:
    def __init__(self):
        self.root = Tk()
        self.root.geometry("300x150")
        self.top_frame = Frame(self.root)
        self.mid_frame = Frame(self.root)
        self.mid2_frame = Frame(self.root)
        self.bottom_frame = Frame(self.root)
        self.root.title("Right Triangle Calculator")
        self.title = Label(self.root, text="This is the login page\n")
        self.title.pack()
        
        #user input for username and password
        self.user_label = Label(self.top_frame, text='Username: ')
        self.pss_label = Label(self.mid_frame, text='Password: ')
        self.user = Entry(self.top_frame)
        self.passw = Entry(self.mid_frame, show='*')
        
        #login button, calls login function
        self.login_button = Button(self.mid2_frame, text='Login', command=self.login)
        #create account button, calls to open the create account window
        self.new_button = Button(self.mid2_frame, text='Create Account', command=self.new_acc)
        #quit button, closes out the program
        self.quit_button = Button(self.mid2_frame,
                                            text='Quit',
                                            command=self.root.destroy)
        
        #sets self.wrong to a string variable from login function
        self.wrong = StringVar()
        #shows label at the bottom of the page, shows if login is unsuccessful
        self.wrong_msg = Label(self.bottom_frame, textvariable=self.wrong, fg = 'red')
        
        #pack's items
        self.user_label.pack(side='left')
        self.pss_label.pack(side='left')
        self.user.pack(side='left')
        self.passw.pack(side='left')
        self.passw.focus()
        self.passw.bind('<Return>', self.login)
        self.login_button.pack(side='left')
        self.new_button.pack(side='left')
        self.quit_button.pack(side='left')
        self.wrong_msg.pack(side='left')
        
        self.top_frame.pack()
        self.mid_frame.pack()
        self.mid2_frame.pack()
        self.bottom_frame.pack()

        self.root.mainloop()
    
#calculation window
    def calc_win(self):
        self.top = Toplevel()
        self.top_frame = Frame(self.top)
        self.mid_frame = Frame(self.top)
        self.mid2_frame = Frame(self.top)
        self.bottom_frame = Frame(self.top)
        self.top.geometry("300x150")
        self.title = Label(self.top, text="This is the calculation page\n")
        self.title.pack()
        
        #user input for side A
        self.sideA = Label(self.top_frame, text="Side A:")
        self.entryA = Entry(self.top_frame,width=10)
        #user input for side B
        self.sideB = Label(self.mid_frame, text="Side B:")
        self.entryB = Entry(self.mid_frame,width=10)
        #prints/show answer to the calculation
        self.value = StringVar()
        self.sideC = Label(self.mid2_frame, text="Side C:")
        self.labelC = Label(self.mid2_frame, textvariable=self.value, borderwidth=1, relief='solid', width=10)
        
        #calculate button, calls to the calculate function to do the pythagorean theorem calculation
        self.calc_button = Button(self.bottom_frame, text="Calculate", command=self.calculate)
        #quit button, closes out the program
        self.quit_button = Button(self.bottom_frame,
                                            text='Quit',
                                            command=self.root.destroy)
        #back button, calls to the back function that takes you back to the login page
        self.back_button = Button(self.bottom_frame, text='Back', command=self.back)
        
        #pack's items
        self.sideA.pack(side='left')
        self.sideB.pack(side='left')
        self.sideC.pack(side='left')
        self.entryA.pack(side='left')
        self.entryB.pack(side='left')
        self.labelC.pack(side='left')
        self.calc_button.pack(side='left')
        self.quit_button.pack(side='left')
        self.back_button.pack(side='left')
        
        self.top_frame.pack()
        self.mid_frame.pack()
        self.mid2_frame.pack()
        self.bottom_frame.pack()
        self.root.withdraw()

#creation account window
    def new_acc(self):
        self.top = Toplevel()
        self.top_frame = Frame(self.top)
        self.mid_frame = Frame(self.top)
        self.mid2_frame = Frame(self.top)
        self.bottom_frame = Frame(self.top)
        self.top.geometry("300x150")
        self.title = Label(self.top, text="This is the account creation page\n")
        self.title.pack()
        
        #user input for new username and password for new account
        self.user_label = Label(self.top_frame, text='Username: ')
        self.pss_label = Label(self.mid_frame, text='Password: ')
        self.new_user = Entry(self.top_frame)
        self.new_passw = Entry(self.mid_frame, show='*')
        
        #create account button, that calls to the create function
        self.new_button = Button(self.mid2_frame, text='Create Account', command=self.create)
        #back button, calls to the back function that takes you back to the login page
        self.back_button = Button(self.mid2_frame, text='Back', command=self.back)
        
        #sets self.created to a string variable from create account function
        self.created = StringVar()
        #shows label at the bottom of the page, shows when a new account is created
        self.created_acc = Label(self.bottom_frame, textvariable=self.created, fg = 'blue')
        
        #pack's items
        self.user_label.pack(side='left')
        self.pss_label.pack(side='left')
        self.new_user.pack(side='left')
        self.new_passw.pack(side='left')
        self.passw.focus()
        self.passw.bind('<Return>', self.login)
        self.new_button.pack(side='left')
        self.back_button.pack(side='left')
        self.created_acc.pack(side = 'left')
        
        self.top_frame.pack()
        self.mid_frame.pack()
        self.mid2_frame.pack()
        self.bottom_frame.pack()
        
        self.root.withdraw()
        
#calculation function, does the pythagorean theorem calculation
    def calculate(self):
        #gets input for the calculation
        sideA = int(self.entryA.get())
        sideB = int(self.entryB.get())
        
        #pythagorean theorem formula
        c = math.sqrt(sideA**2 + sideB**2)
        
        #sets the self.value to the output of the equation above as a string and rounded to the second decimal
        self.value.set(str(round(c,2)))
        
#login function, gets the user input and checks input against the items in users.txt
    def login(self):
        #gets username and password
        user = str(self.user.get())
        psw = str(self.passw.get())
        #opens and reads file
        check = open('users.txt','r')
        #for loop that checks user input against users.txt
        for line in check.readlines():
            us, pw = line.strip().split(' | ')
            if (user in us) and (psw in pw):
                self.calc_win()
                return True
        #prints error msg if input doesn't match items in users.txt
        self.wrong.set(value='Wrong username or password')
        return False
        
#create a new account function, add's username and password to user.txt file
    def create(self):
        #gets username and password
        user = str(self.new_user.get())
        passw = str(self.new_passw.get())
        #opens and appends file
        add = open('users.txt', 'a')
        #writes to the file
        add.write(user + ' | ' + passw + '\n')
        #closes file
        add.close()
        #prints successful login creation msg when a new account is created
        self.created.set(value='Successfully created account')
        
    def back(self):
        #closes the current window (account creation or calculation window)
        self.top.withdraw()
        #reopens the login window
        self.root.deiconify()
w=window()

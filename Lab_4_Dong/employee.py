class Employee:
    def __init__(self, name, ID_number, department, job_title):
        self.name = name
        self.ID_number = ID_number
        self.department = department
        self.job_title = job_title
        
    def set_name(self, name):
        self.name = name
    def set_ID_number(self, ID_number):
        self.ID_number = ID_number
    def set_department(self, department):
        self.department = department
    def set_job_title(self, job_title):
        self.job_title = job_title
    
    def get_name(self):
        return self.__name
    def get_ID_number(self):
        return self.__ID_number
    def get_department(self):
        return self.__department
    def get_job_title(self):
        return self.__job_title
        
    def __str__(self):
        return f'Employee Info\n ID: {self.ID_number}\n Name: {self.name}\n Department: {self.department}\n Job Title: {self.job_title}'

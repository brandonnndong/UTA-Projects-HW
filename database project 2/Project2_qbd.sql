spool "G:\INSY 3304\Project2_qbd.txt"
	-- Include the full path. This will start logging to the specified file.
set echo ON
--Quang Minh Dong
--INSY 3304-001
--Project 2
	
-- Drop table
BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE Appt_qbd';
    EXECUTE IMMEDIATE 'DROP TABLE Patient_qbd';
    EXECUTE IMMEDIATE 'DROP TABLE Billing_qbd';
    EXECUTE IMMEDIATE 'DROP TABLE Treatment_qbd';
    EXECUTE IMMEDIATE 'DROP TABLE BlockCode_qbd';
    EXECUTE IMMEDIATE 'DROP TABLE AppointmentStatus_qbd';
    EXECUTE IMMEDIATE 'DROP TABLE Insurance_qbd';
    EXECUTE IMMEDIATE 'DROP TABLE Provider_qbd';
    EXECUTE IMMEDIATE 'DROP TABLE ApptDetail_qbd';
EXCEPTION
    WHEN OTHERS THEN
        IF SQLCODE != -942 THEN 
            RAISE;
        END IF;
END;
/
-- Part I

CREATE TABLE Appt_qbd (
    ApptID NUMBER(5) PRIMARY KEY,
    ApptDate DATE,
    ApptTime VARCHAR2(8),
    PatientID NUMBER(5),
    BillingType VARCHAR2(11),
    InsCoID NUMBER(5),
    ProvID NUMBER(5),
    ApptStatusCode VARCHAR2(10),
    PmtStatus VARCHAR2(9)
);
-- Table created.

CREATE TABLE Patient_qbd (
    PatientID NUMBER(5) PRIMARY KEY,
    PatientFName VARCHAR2(20),
	PatientLName VARCHAR2(20),
    PatientPhone VARCHAR2(10)
);
-- Table created.

CREATE TABLE Billing_qbd (
	BillingType VARCHAR2(11) PRIMARY KEY,
	BillingTypeDesc VARCHAR2(20)
);
--Table created.

CREATE TABLE Treatment_qbd (
    TreatmentCode VARCHAR2(5) PRIMARY KEY,
    TreatmentDesc VARCHAR2(25),
    TreatmentRate NUMBER(10, 2),
    BlockCode VARCHAR2(5)
);
-- Table created.

CREATE TABLE BlockCode_qbd (
	BlockCode VARCHAR2(5) PRIMARY KEY,
    BlockDesc VARCHAR2(20),
    BlockMinutes NUMBER(5)
);
-- Table created.

CREATE TABLE AppointmentStatus_qbd (
    ApptStatusCode VARCHAR2(10) PRIMARY KEY,
    ApptStatusDesc VARCHAR2(20)
);
-- Table created.

CREATE TABLE Insurance_qbd (
    InsCoID NUMBER(5) PRIMARY KEY,
    InsCoName VARCHAR2(15)
);
-- Table created.

CREATE TABLE Provider_qbd (
    ProvID NUMBER(5) PRIMARY KEY,
    ProvFName VARCHAR2(20),
	ProvLName VARCHAR2(20)
);
-- Table created.

CREATE TABLE ApptDetail_qbd (
    ApptID NUMBER(5),
    TreatmentCode VARCHAR2(5),
    PRIMARY KEY (ApptID, TreatmentCode)
);
-- Table created.
SET LINESIZE 150
COLUMN TreatmentCode HEADING CODE
COLUMN PatientPhone HEADING PHONE

DESCRIBE Appt_qbd;
-- Shows the structure of Appt_qbd table.

DESCRIBE Patient_qbd;
-- Shows the structure of Patient_qbd table.

DESCRIBE Billing_qbd;
-- Shows the structure of Billing_qbd table.

DESCRIBE Treatment_qbd;
-- Shows the structure of Treatment_qbd table.

DESCRIBE BlockCode_qbd;
-- Shows the structure of BlockCode_qbd table.

DESCRIBE AppointmentStatus_qbd;
-- Shows the structure of AppointmentStatus_qbd table.

DESCRIBE Insurance_qbd;
-- Shows the structure of Insurance_qbd table.

DESCRIBE Provider_qbd;
-- Shows the structure of Provider_qbd table.

DESCRIBE ApptDetail_qbd;
-- Shows the structure of ApptDetail_qbd table.
		
-- Part IIA

-- Insert data into Billing_qbd
INSERT INTO Billing_qbd (BillingType, BillingTypeDesc) 
VALUES ('I', 'Insurance');
-- Row inserted
INSERT INTO Billing_qbd (BillingType, BillingTypeDesc) 
VALUES ('WC', 'Workers Comp');
-- Row inserted
INSERT INTO Billing_qbd (BillingType, BillingTypeDesc) 
VALUES ('SP', 'Self Pay');
-- Row inserted

-- Insert data into Insurance_qbd
INSERT INTO Insurance_qbd (InsCoID, InsCoName) 
VALUES (323, 'Humana');
-- Row inserted
INSERT INTO Insurance_qbd (InsCoID, InsCoName) 
VALUES (129, 'Blue Cross');
-- Row inserted
INSERT INTO Insurance_qbd (InsCoID, InsCoName) 
VALUES (210, 'State Farm');
-- Row inserted
INSERT INTO Insurance_qbd (InsCoID, InsCoName) 
VALUES (135, 'TriCare');
-- Row inserted

-- Insert data into Provider_qbd
INSERT INTO Provider_qbd (ProvID, ProvFName, ProvLName) 
VALUES (2, 'Michael', 'Smith');
-- Row inserted
INSERT INTO Provider_qbd (ProvID, ProvFName, ProvLName) 
VALUES (5, 'Janice', 'May');
-- Row inserted
INSERT INTO Provider_qbd (ProvID, ProvFName, ProvLName) 
VALUES (1, 'Kay', 'Jones');
-- Row inserted
INSERT INTO Provider_qbd (ProvID, ProvFName, ProvLName) 
VALUES (3, 'Ray', 'Schultz');
-- Row inserted

-- Insert data into BlockCode_qbd
INSERT INTO BlockCode_qbd (BlockCode, BlockDesc, BlockMinutes) 
VALUES ('L1', 'Level 1', 15);
-- Row inserted
INSERT INTO BlockCode_qbd (BlockCode, BlockDesc, BlockMinutes) 
VALUES ('L2', 'Level 2', 20);
-- Row inserted
INSERT INTO BlockCode_qbd (BlockCode, BlockDesc, BlockMinutes) 
VALUES ('L3', 'Level 3', 30);
-- Row inserted
INSERT INTO BlockCode_qbd (BlockCode, BlockDesc, BlockMinutes) 
VALUES ('L4', 'Level 4', 60);
-- Row inserted

-- Insert data into AppointmentStatus_qbd
INSERT INTO AppointmentStatus_qbd (ApptStatusCode, ApptStatusDesc) 
VALUES ('CM', 'Complete');
-- Row inserted
INSERT INTO AppointmentStatus_qbd (ApptStatusCode, ApptStatusDesc) 
VALUES ('CN', 'Confirmed');
-- Row inserted
INSERT INTO AppointmentStatus_qbd (ApptStatusCode, ApptStatusDesc) 
VALUES ('NC', 'Not Confirmed');
-- Row inserted
INSERT INTO AppointmentStatus_qbd (ApptStatusCode, ApptStatusDesc) 
VALUES ('PD', 'Paid in Full');
-- Row inserted
INSERT INTO AppointmentStatus_qbd (ApptStatusCode, ApptStatusDesc) 
VALUES ('PP', 'Partial Pmt');
-- Row inserted

-- Insert data into Treatment_qbd
INSERT INTO Treatment_qbd (TreatmentCode, TreatmentDesc, TreatmentRate, BlockCode) 
VALUES ('NP', 'New Patient', 45, 'L1');
-- Row inserted
INSERT INTO Treatment_qbd (TreatmentCode, TreatmentDesc, TreatmentRate, BlockCode) 
VALUES ('GBP', 'General Back Pain', 60, 'L2');
-- Row inserted
INSERT INTO Treatment_qbd (TreatmentCode, TreatmentDesc, TreatmentRate, BlockCode) 
VALUES ('XR', 'X Ray', 250, 'L2');
-- Row inserted
INSERT INTO Treatment_qbd (TreatmentCode, TreatmentDesc, TreatmentRate, BlockCode) 
VALUES ('PSF', 'Post Surgery Follow Up', 30, 'L1');
-- Row inserted
INSERT INTO Treatment_qbd (TreatmentCode, TreatmentDesc, TreatmentRate, BlockCode) 
VALUES ('SR', 'Suture Removal', 50, 'L2');
-- Row inserted
INSERT INTO Treatment_qbd (TreatmentCode, TreatmentDesc, TreatmentRate, BlockCode) 
VALUES ('PT30', 'Physical Therapy 30', 60, 'L3');
-- Row inserted
--INSERT INTO Treatment_qbd (TreatmentCode, TreatmentDesc, TreatmentRate, BlockCode) 
--VALUES ('NP', 'New Patient', 45, 'L1');
-- Row inserted
INSERT INTO Treatment_qbd (TreatmentCode, TreatmentDesc, TreatmentRate, BlockCode) 
VALUES ('BI', 'Back Injury', 60, 'L2');
-- Row inserted
INSERT INTO Treatment_qbd (TreatmentCode, TreatmentDesc, TreatmentRate, BlockCode) 
VALUES ('PT60', 'Physical Therapy 60', 110, 'L4');
-- Row inserted

-- Insert data into Patient_qbd
INSERT INTO Patient_qbd (PatientID, PatientFName, PatientLName, PatientPhone) 
VALUES (101, 'Wesley', 'Tanner', '8175551193');
-- Row inserted
INSERT INTO Patient_qbd (PatientID, PatientFName, PatientLName, PatientPhone) 
VALUES (100, 'Brenda', 'Rhodes', '2145559191');
-- Row inserted
INSERT INTO Patient_qbd (PatientID, PatientFName, PatientLName, PatientPhone) 
VALUES (15, 'Jeff', 'Miner', '4695552301');
-- Row inserted
INSERT INTO Patient_qbd (PatientID, PatientFName, PatientLName, PatientPhone) 
VALUES (77, 'Kim', 'Jackson', '8175554911');
-- Row inserted
INSERT INTO Patient_qbd (PatientID, PatientFName, PatientLName, PatientPhone) 
VALUES (119, 'Mary', 'Vaughn', '8175552334');
-- Row inserted
INSERT INTO Patient_qbd (PatientID, PatientFName, PatientLName, PatientPhone) 
VALUES (28, 'Renee', 'Walker', '2145559285');
-- Row inserted
INSERT INTO Patient_qbd (PatientID, PatientFName, PatientLName, PatientPhone) 
VALUES (84, 'James', 'Clayton', '2145559285');
-- Row inserted
INSERT INTO Patient_qbd (PatientID, PatientFName, PatientLName, PatientPhone) 
VALUES (23, 'Shelby', 'Davis', '8175551198');
-- Row inserted

-- Insert data into Appt_qbd
INSERT INTO Appt_qbd (ApptID, ApptDate, ApptTime, PatientID, BillingType, InsCoID, ProvID, ApptStatusCode, PmtStatus) 
VALUES (101, TO_DATE('20240219 0900 AM', 'YYYYMMDD HH:MI AM'), '0900 AM', 101, 'I', 323, 2, 'CM', 'PD');
-- Row inserted
INSERT INTO Appt_qbd (ApptID, ApptDate, ApptTime, PatientID, BillingType, InsCoID, ProvID, ApptStatusCode, PmtStatus) 
VALUES (102, TO_DATE('20240219 0900 AM', 'YYYYMMDD HH:MI AM'), '0900 AM', 100, 'I', 129, 5, 'CM', 'PP');
-- Row inserted
INSERT INTO Appt_qbd (ApptID, ApptDate, ApptTime, PatientID, BillingType, InsCoID, ProvID, ApptStatusCode, PmtStatus) 
VALUES (103, TO_DATE('20240219 1000 AM', 'YYYYMMDD HH:MI AM'), '1000 AM', 15, 'SP', 2, 2, 'CM', 'PD');
-- Row inserted
INSERT INTO Appt_qbd (ApptID, ApptDate, ApptTime, PatientID, BillingType, InsCoID, ProvID, ApptStatusCode, PmtStatus) 
VALUES (104, TO_DATE('20240219 1030 AM', 'YYYYMMDD HH:MI AM'), '1030 AM', 77, 'WC', 210, 1, 'CM', 'PD');
-- Row inserted
INSERT INTO Appt_qbd (ApptID, ApptDate, ApptTime, PatientID, BillingType, InsCoID, ProvID, ApptStatusCode, PmtStatus) 
VALUES (105, TO_DATE('20240219 1030 AM', 'YYYYMMDD HH:MI AM'), '1030 AM', 119, 'I', 129, 2, 'CM', 'PP');
-- Row inserted
INSERT INTO Appt_qbd (ApptID, ApptDate, ApptTime, PatientID, BillingType, InsCoID, ProvID, ApptStatusCode, PmtStatus) 
VALUES (106, TO_DATE('20240219 1030 AM', 'YYYYMMDD HH:MI AM'), '1030 AM', 97, 'SP', 3, 3, 'CM', 'NP');
-- Row inserted
INSERT INTO Appt_qbd (ApptID, ApptDate, ApptTime, PatientID, BillingType, InsCoID, ProvID, ApptStatusCode, PmtStatus) 
VALUES (107, TO_DATE('20240219 1130 AM', 'YYYYMMDD HH:MI AM'), '1130 AM', 28, 'I', 129, 3, 'CM', 'PP');
-- Row inserted
INSERT INTO Appt_qbd (ApptID, ApptDate, ApptTime, PatientID, BillingType, InsCoID, ProvID, ApptStatusCode, PmtStatus) 
VALUES (108, TO_DATE('20240219 1130 AM', 'YYYYMMDD HH:MI AM'), '1130 AM', 105, 'I', 323, 2, 'CM', 'NP');
-- Row inserted
INSERT INTO Appt_qbd (ApptID, ApptDate, ApptTime, PatientID, BillingType, InsCoID, ProvID, ApptStatusCode, PmtStatus) 
VALUES (109, TO_DATE('20240219 0200 PM', 'YYYYMMDD HH:MI AM'), '0200 PM', 84, 'I', 135, 5, 'CM', 'NP');
-- Row inserted
INSERT INTO Appt_qbd (ApptID, ApptDate, ApptTime, PatientID, BillingType, InsCoID, ProvID, ApptStatusCode, PmtStatus) 
VALUES (110, TO_DATE('20240220 0830 AM', 'YYYYMMDD HH:MI AM'), '0830 AM', 84, 'I', 135, 3, 'NC', 'NP');
-- Row inserted
INSERT INTO Appt_qbd (ApptID, ApptDate, ApptTime, PatientID, BillingType, InsCoID, ProvID, ApptStatusCode, PmtStatus) 
VALUES (111, TO_DATE('20240220 0830 AM', 'YYYYMMDD HH:MI AM'), '0830 AM', 23, 'WC', 323, 5, 'CN', 'NP');
-- Row inserted

COMMIT;
-- Commit complete

-- Part IIB

-- Select all data from Appt_qbd
SELECT * FROM Appt_qbd;
-- (Display all rows from Appt_qbd)

-- Select all data from Patient_qbd
SELECT * FROM Patient_qbd;
-- (Display all rows from Patient_qbd)

-- Select all data from Billing_qbd
SELECT * FROM Billing_qbd;
-- (Display all rows from Billing_qbd)

-- Select all data from Treatment_qbd
SELECT * FROM Treatment_qbd;
-- (Display all rows from Treatment_qbd)

-- Select all data from BlockCode_qbd
SELECT * FROM BlockCode_qbd;
-- (Display all rows from BlockCode_qbd)

-- Select all data from AppointmentStatus_qbd
SELECT * FROM AppointmentStatus_qbd;
-- (Display all rows from AppointmentStatus_qbd)

-- Select all data from Insurance_qbd
SELECT * FROM Insurance_qbd;
-- (Display all rows from Insurance_qbd)

-- Select all data from Provider_qbd
SELECT * FROM Provider_qbd;
-- (Display all rows from Provider_qbd)

-- Select all data from ApptDetail_qbd
SELECT * FROM ApptDetail_qbd;
-- (Display all rows from ApptDetail_qbd)

--Part III

-- Update the phone number of Patient 100
UPDATE Patient_qbd 
SET PatientPhone = '2145551234' 
WHERE PatientID = 100;
-- Row updated

-- Add Patient 120 (Amanda Green, no phone number)
INSERT INTO Patient_qbd (PatientID, PatientFName, PatientLName, PatientPhone) 
VALUES (120, 'Amanda', 'Green', NULL);
-- Row inserted

-- Add treatments to the Treatment table
INSERT INTO Treatment_qbd (TreatmentCode, TreatmentDesc, TreatmentRate, BlockCode) 
VALUES ('CI1', 'Cortizone Injection 1', 50, 'L1');
-- Row inserted

INSERT INTO Treatment_qbd (TreatmentCode, TreatmentDesc, TreatmentRate, BlockCode) 
VALUES ('CI2', 'Cortizone Injection 1', 100, 'L1');
-- Row inserted

-- Update the appointment date/time for Appt 108
UPDATE Appt_qbd 
SET ApptDate = TO_DATE('20240221 1130 AM', 'YYYYMMDD HH:MI AM') 
WHERE ApptID = 108;
-- Row updated

-- Change the billing type of Appt 107 to WC
UPDATE Appt_qbd 
SET BillingType = 'WC' 
WHERE ApptID = 107;
-- Row updated

-- Add a new appointment
INSERT INTO Appt_qbd (ApptID, ApptDate, ApptTime, PatientID, BillingType, InsCoID, ProvID, ApptStatusCode, PmtStatus) 
VALUES (112, TO_DATE('20240221 0900 AM', 'YYYYMMDD HH:MI AM'), '0900 AM', 120, 'SP', NULL, 2, 'NC', 'NP');
-- Row inserted

-- Add treatment codes for Appt 112
INSERT INTO ApptDetail_qbd (ApptID, TreatmentCode) VALUES (112, 'NP');
-- Row inserted

INSERT INTO ApptDetail_qbd (ApptID, TreatmentCode) VALUES (112, 'HP');
-- Row inserted

INSERT INTO ApptDetail_qbd (ApptID, TreatmentCode) VALUES (112, 'CI2');
-- Row inserted

-- Delete the treatment code 'BI' from Appt 105
DELETE FROM ApptDetail_qbd 
WHERE ApptID = 105 AND TreatmentCode = 'BI';
-- Row deleted

-- Add treatment code 'GBP' for Appt 105
INSERT INTO ApptDetail_qbd (ApptID, TreatmentCode) 
VALUES (105, 'GBP');
-- Row inserted

-- Commit the transactions
COMMIT;
-- Commit complete

-- Part IV

-- Select all data from Appt_qbd
SELECT * FROM Appt_qbd ORDER BY ApptID;
-- (Display all rows from Appt_qbd)

-- Select all data from Patient_qbd
SELECT * FROM Patient_qbd ORDER BY PatientID;
-- (Display all rows from Patient_qbd)

-- Select all data from Billing_qbd
SELECT * FROM Billing_qbd ORDER BY BillingType;
-- (Display all rows from Billing_qbd)

-- Select all data from Treatment_qbd
SELECT * FROM Treatment_qbd ORDER BY TreatmentCode;
-- (Display all rows from Treatment_qbd)

-- Select all data from BlockCode_qbd
SELECT * FROM BlockCode_qbd ORDER BY BlockCode;
-- (Display all rows from BlockCode_qbd)

-- Select all data from AppointmentStatus_qbd
SELECT * FROM AppointmentStatus_qbd ORDER BY ApptStatusCode;
-- (Display all rows from AppointmentStatus_qbd)

-- Select all data from Insurance_qbd
SELECT * FROM Insurance_qbd ORDER BY InsCoID;
-- (Display all rows from Insurance_qbd)

-- Select all data from Provider_qbd
SELECT * FROM Provider_qbd ORDER BY ProvID;
-- (Display all rows from Provider_qbd)

-- Select all data from ApptDetail_qbd
SELECT * FROM ApptDetail_qbd ORDER BY ApptID, TreatmentCode;
-- (Display all rows from ApptDetail_qbd)

set echo OFF
spool OFF
import csv

with open("Data/Video_Games_Sales_as_at_22_Dec_2016.csv") as file:
    csv_object= csv.reader(file)
    for row in csv_object:
                print("CSV row: {0}".format(row))

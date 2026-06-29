#include <iostream>
#include <string>
using namespace std;
void displayGrades(const string names[], const double grades[], int size);
char calculateGradeChar(double score);
int main() {
    int totalStudents;

    cout <<endl;
    cout << "      Students Grading System           " << endl;
    cout <<endl;
    cout << "Enter the number of students: ";
    cin >> totalStudents;
    if (totalStudents <= 0) {
        cout << "Invalid number of students!" << endl;
        return 1;
    }
    string studentNames[totalStudents];
    double studentGrades[totalStudents];
    for (int i = 0; i < totalStudents; i++) {
        cout << "\nEnter name for student #" << i + 1 << ": ";
        cin >> studentNames[i];

        cout << "Enter grade for " << studentNames[i] << " (0-100): ";
        cin >> studentGrades[i];
        if (studentGrades[i] < 0 || studentGrades[i] > 100) {
            cout << "Invalid grade! Please enter a value between 0 and 100." << endl;
            i--; 
        }
    }
    displayGrades(studentNames, studentGrades, totalStudents);
    return 0;
}
char calculateGradeChar(double score) {
    int range = 0;
    if (score >= 90 && score <= 100) {
        range = 1;
    } else if (score >= 80 && score < 90) {
        range = 2;
    } else if (score >= 70 && score < 80) {
        range = 3;
    } else if (score >= 60 && score < 70) {
        range = 4;
    } else if (score >= 0 && score < 60) {
        range = 5;
    }
    char letterGrade;
    switch (range) {
        case 1:
            letterGrade = 'A';
            break;
        case 2:
            letterGrade = 'B';
            break;
        case 3:
            letterGrade = 'C';
            break;
        case 4:
            letterGrade = 'D';
            break;
        case 5:
            letterGrade = 'F';
            break;
        default:
            letterGrade = 'X';
    }
    return letterGrade;
}

void displayGrades(const string names[], const double grades[], int size) {
    cout <<endl;
    cout << "             FINAL REPORT               " << endl;
    cout <<endl;
    cout << "Student Name\tScore\tGrade" << endl;
   cout<< endl;

    for (int i = 0; i < size; i++) {
        char gradeLetter = calculateGradeChar(grades[i]);
        cout << names[i] << "\t\t" << grades[i] << "\t" << gradeLetter << endl;
    cout<< endl;
}

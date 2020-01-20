
'use strict'

const employeeName = document.getElementById("employeeName");
const employeeTitle = document.getElementById("employeeTitle");
const employeeEmail = document.getElementById("employeeEmail");
const reportsto = document.getElementById("reportsTo");

const employeeUri = "http://localhost:8080/Project1/employeePage";

document.addEventListener('DOMContentLoaded', getEmployee);

async function getEmployee(){
    
    await fetch(employeeUri)
    .then(res=>console.log(res))
}
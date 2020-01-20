'use strict'

const button = document.getElementById('button');
const form = document.getElementById('form');
const formInput = document.getElementById('formInput');
const updateButon = document.getElementById("updateButton");

const getEmployeeUri = "http://localhost:8080/Project1/getemployee";
const postEmployeeUri = "http://localhost:8080/Project1/postemployee";
const employeeUpdateUri = "http://localhost:8080/Project1/update";

button.addEventListener("click", getData);
form.addEventListener("submit", postData);
updateButon.addEventListener("click", updateData);

async function getData(event){
    event.preventDefault();
    await fetch(getEmployeeUri)
    .then(res=>console.log(res))
}
async function postData(event){

    event.preventDefault();
    let formVal = {};
    formVal.employeeNumber = formInput.value;

    await fetch(postEmployeeUri,
        { method: 'POST', body: JSON.stringify(formVal)}
        )
    .then(res => console.log(res))
}
async function updateData(event){
    event.preventDefault();
    await fetch(employeeUpdateUri)
    .then(res=>console.log(res))
}
'use strict'
//==========================================================================
//------------------ Request Reimbursement Variables -----------------------------
//==========================================================================
let employeeUpdateContainer = document.getElementById("employeeUpdateContainer");
let employeeUpdateUrl = "http://localhost:8080/Project1/employeeupdate";
let updatedEmployeeData;
let updateEmployeeVal = {};
//--------------------------------------------------------------------
//Place this inside of the EmployeeInfo section 
let reimbursement = document.getElementById("reimbursement");
//--------------------------------------------------------------------
let requestReimbursementContainer = document.createElement("div");
requestReimbursementContainer.setAttribute("id", "requestReimbursementContainer");
//--------------------------------------------------------------------
let requestReimbursementForm = document.createElement("form");
requestReimbursementForm.setAttribute("id", "requestReimbursementForm");
//--------------------------------------------------------------------
let amountRequested = document.createElement("input");
amountRequested.setAttribute("type", "text");
amountRequested.setAttribute("name", "amountRequested");
amountRequested.setAttribute("id", "amountReqested");
amountRequested.setAttribute("placeholder", "Amount Requested");
//--------------------------------------------------------------------
let purposeForRequest = document.createElement("input");
purposeForRequest.setAttribute("type", "text");
purposeForRequest.setAttribute("name", "purposeForRequest");
purposeForRequest.setAttribute("id", "purposeForRequest");
purposeForRequest.setAttribute("placeholder", "Purpose For Request");
//--------------------------------------------------------------------
let reimbursementRequestSubmit = document.createElement("input");
reimbursementRequestSubmit.setAttribute("type", "submit");
let reimbursementRequestSubmitTxt = document.createTextNode("Submit Reimbursement");
reimbursementRequestSubmit.appendChild(reimbursementRequestSubmitTxt);
//--------------------------------------------------------------------

    requestReimbursementForm.appendChild(amountRequested);
    requestReimbursementForm.appendChild(purposeForRequest);
    requestReimbursementForm.appendChild(reimbursementRequestSubmit);
    requestReimbursementContainer.appendChild(requestReimbursementForm);
    reimbursement.appendChild(requestReimbursementContainer);
    

    async function submit(e){
        e.preventDefault();

        employeeData.employeeFirstName = empfstnm.value;
        employeeData.employeeLastName = emplstnm.value;
        console.log(empfstnm.value)
        console.log(emplstnm.value)

        console.log(employeeData)
        await fetch(employeeUpdateUrl, {method: 'POST', body: JSON.stringify(employeeData)})
        .then(response => response.text())
        .then((data)=>{
            updatedEmployeeData = JSON.parse(data)
        })
        console.log(updatedEmployeeData.employeeFirstName);
        while (employeeInfo.hasChildNodes()) {  
            employeeInfo.removeChild(employeeInfo.firstChild);
          }
        // employeeInfo.removeChild(employeeForm);
        createEmployeeInfo();
    };


//========================================================================
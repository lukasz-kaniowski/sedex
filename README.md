# Note to reviewers

I've decided to do backend implementation. At current stage it doesn't support `address` section. 
It also requires improvements in data validation.  

At the end I've put some quick and dirty react form using formik. It works but lacks tests.  

## Sedex Connect - Fullstack Tech Test

This is an example technical test for a full stack developer. 💻

It aims to give the interviewee the opportunity to show their knowledge by implementing the `POST /company` 
method of the [open api spec](./companies-openapi3.yaml) in either the frontend OR the backend.
  

### Frontend
If you choose the to implement frontend please do so in React, feel free to use whatever libs to assist your 
implementation but please include the dependencies in the build tool:

- Create a page that will allow a user to submit a company via a form and display the response.
- You can use the following endpoint to implement against: https://sedex-apim-gateway.cloud.gravitee.io/interview/v0/...


### Backend
If you choose to implement the backend please do Kotlin, feel free to use whatever libs to assist your implementation 
but please include the dependencies in the build tool.

- Expose the endpoint as a Restful HTTP service consuming and returning a JSON response as per the api spec.

### Solution structure

To start please fork this repository, make publicly accessible so that we can review at the end. 

We are looking for clean and tested code. Please provide a courteous notes appended to this README on tools and libs 
you might have used and with instructions on how to test and run the application locally.  

The project can be organised you see fit, in this repo are some example front and backend projects to point you in the
 right direction, but feel free to throw away and implement your version as you see fit, however we do ask that all the 
 code required to run the solution is submitted to a to your public fork of this repo.

Please time box the exercise to  a hour and a half maximum. Git commits would be appreciated to show the solutions 
evolution. 

If you cant implement the full POST company specification in an hour and a half, dont worry, just put down a few steps 
that you would go on to implement to complete the spec and the time you estimate that it would take to complete.

Thanks! 😃

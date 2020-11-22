import React, {useState} from 'react';
import {useFormik} from 'formik';

const CompanyDetails = ({companyName, companyType, emailAddress, id}) => {
    return (
        <div>
            Company name: {companyName} <br/>
            Company type: {companyType} <br/>
            Email address: {emailAddress} <br/>
            ID: {id} <br/>
        </div>
    )
}

const CompanyForm = () => {
    const [savedCompany, setSavedCompany] = useState()
    const [error, setError] = useState()

    const formik = useFormik({
        initialValues: {
            companyName: '',
            companyType: '',
            emailAddress: null,
        },
        onSubmit: values => {
            fetch("http://localhost:8080/interview/v0/company", {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(values)
            })
                .then((res) => res.json())
                .then((data) =>
                    setSavedCompany(data)
                ).catch(err => setError(err.message))

        },
    });
    return (
        <>
            {
                savedCompany ?
                    <div>
                        <h1>Company saved</h1>
                        <CompanyDetails {...savedCompany}/>
                    </div>

                    :
                    <>
                        {error ? <h1>There was an error: {error}</h1> : ""}
                        <form onSubmit={formik.handleSubmit}>
                            <label htmlFor="companyName">Company Name</label>
                            <input
                                id="companyName"
                                name="companyName"
                                type="text"
                                onChange={formik.handleChange}
                                value={formik.values.companyName}
                            />
                            <label htmlFor="companyType">Company Type</label>
                            <input
                                id="companyType"
                                name="companyType"
                                type="text"
                                onChange={formik.handleChange}
                                value={formik.values.companyType}
                            />
                            <label htmlFor="emailAddress">Email Address</label>
                            <input
                                id="emailAddress"
                                name="emailAddress"
                                type="emailAddress"
                                onChange={formik.handleChange}
                                value={formik.values.emailAddress}
                            />
                            <button type="submit">Save</button>
                        </form>
                    </>
            }

        </>
    );
};

export default CompanyForm

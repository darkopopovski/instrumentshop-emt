import React from 'react';
import { useNavigate } from 'react-router-dom';

const BrandsAdd = (props) => {

    const history = useNavigate();
    const [formData, updateFormData] = React.useState({
        id: 121,
        name: "",
        since: ""
    })

    const handleChange = (e) => {
        updateFormData({
            ...formData,
            [e.target.name]: e.target.value.trim(),
            [e.target.since]: e.target.value.trim()
        })
    }

    const onFormSubmit = (e) => {
        e.preventDefault();
        const id = formData.id;
        const name = formData.name;
        const since = formData.since;


        props.onAddProduct(id, name, since);
        history.push("/brands");
    }

    return ( < div className = "row mt-5" >
        <
        div className = "col-md-5" >
        <
        form onSubmit = { onFormSubmit } >
        <
        div className = "form-group" >
        <
        label htmlFor = "id" > Brand ID < /label> <input type = "number"
        className = "form-control"
        id = "id"
        name = "id"
        required placeholder = "Enter product id"
        onChange = { handleChange }
        /> </div > < div className = "form-group" >
        <
        label htmlFor = "name" > Brand name < /label> <input type = "text"
        className = "form-control"
        id = "name"
        name = "name"
        required placeholder = "Enter product name"
        onChange = { handleChange }
        /> </div >

        <
        div className = "form-group" >
        <
        label htmlFor = "since" > Brand Since < /label> <input type = "text"
        className = "form-control"
        id = "since"
        name = "since"
        placeholder = "Since"
        required onChange = { handleChange }
        />  <
        /div> <
        button id = "submit"
        type = "submit"
        className = "btn btn-primary" > Submit < /button>  <
        /form>  <
        /div>  <
        /div>
    )
}

export default BrandsAdd;
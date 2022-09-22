import React from 'react';
import { useNavigate } from 'react-router-dom';

const ProductAdd = (props) => {

    const history = useNavigate();
    const [formData, updateFormData] = React.useState({
        id: 121,
        name: "",
        year: "",
        brand: 1
    })

    const handleChange = (e) => {
        updateFormData({
            ...formData,
            [e.target.name]: e.target.value.trim(),
            [e.target.year]: e.target.value.trim()
        })
    }

    const onFormSubmit = (e) => {
        e.preventDefault();
        const id = formData.id;
        const name = formData.name;
        const year = formData.year;
        const brand = formData.brand;


        props.onAddProduct(id, name, year, brand);
        history.push("/products");
    }

    return ( < div className = "row mt-5" >
        <
        div className = "col-md-5" >
        <
        form onSubmit = { onFormSubmit } >
        <
        div className = "form-group" >
        <
        label htmlFor = "id" > Product ID < /label> <input type = "number"
        className = "form-control"
        id = "id"
        name = "id"
        required placeholder = "Enter product id"
        onChange = { handleChange }
        /> </div > < div className = "form-group" >
        <
        label htmlFor = "name" > Product name < /label> <input type = "text"
        className = "form-control"
        id = "name"
        name = "name"
        required placeholder = "Enter product name"
        onChange = { handleChange }
        /> </div >

        <
        div className = "form-group" >
        <
        label htmlFor = "year" > Year < /label> <input type = "text"
        className = "form-control"
        id = "year"
        name = "year"
        placeholder = "Year"
        required onChange = { handleChange }
        /> </div >

        <
        div className = "form-group" >
        <
        label > Brand < /label> <select name = "brand"
        className = "form-control"
        onChange = { handleChange } > {
            props.brands.map((term) =>
                <
                option value = { term.brand_id } > { term.brand_name } < /option>
            )
        } < /select> </div >
        <
        button id = "submit"
        type = "submit"
        className = "btn btn-primary" > Submit < /button>  <
        /form>  <
        /div>  <
        /div>
    )
}

export default ProductAdd;
import React from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import { Link } from 'react-router-dom';
const brands = (props) => {
    return ( < div className = { "container mm-4 mt-5" } >
        <
        div className = { "row" } >
        <
        div className = { "table-responsive" } >
        <
        table className = { "table table-striped" } >
        <
        thead >
        <
        tr >
        <
        th scope = { "col" } > Name < /th> <th scope = { "col" } > Since </th > < /tr > </thead > < tbody > {
            props.brands.map((term) => {
                return ( < tr >
                    <
                    td > { term.brand_name } < /td>  <
                    td > { term.brand_since } < /td> <td className = { "text-right" } > <
                    a title = { "Delete" }
                    className = { "btn btn-danger" }
                    onClick = {
                        () => props.onDelete(props.term.brand_id)
                    } >
                    Delete < /a> </td >
                    <
                    /tr >
                );
            })
        } < /tbody> </table > < /div> </div > < /div>
    );
}

export default brands;
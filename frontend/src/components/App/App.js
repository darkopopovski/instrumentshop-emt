import './App.css';
import React, { Component } from "react";
import Brands from '../Brands/Brands';
import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom';
import EShopService from "../../repository/eshopRepository";
import Header from "../Header/Header";
import Login from "../Login/Login";
import Products from "../Products/productTerm";
import 'bootstrap/dist/css/bootstrap.min.css';
import ProductAdd from '../Products/productAdd';
import BrandsAdd from '../Brands/brandsAdd';
class App extends Component {

    constructor(props) {
        super(props);
        this.state = {
            brands: [],
            products: []
        }
    }

    render() {
            return ( <Router >
                    <Header />
                    <main >
                    <div className = "container" >
                    <Routes >

                    <Route path = { "/brands" }
                    exact element = { < Brands brands = { this.state.brands }
                        />}/>
                        <Route path = { "/products" }
                        exact element = { < Products products = { this.state.products }
                            onDeleteProduct = { this.deleteProduct }
                            />}/>
                            < Route path = { "/login" } exact element = { < Login onLogin = { this.fetchData }/>}/>

.
                                <Route path = { "/products/add" }exact element = { <ProductAdd brands = { this.state.brands } onAddProduct = { this.addProduct }/>}/>
                                <Route path = { "/brands/add" }exact element = { <BrandsAdd onAddBrands = { this.addBrand }/>}/>


                                    </Routes> 
                                    </div>

                                    </main>
                                    </Router >
                                );

                            }
                            componentDidMount() {
                                this.fetchData()
                            }

                            fetchData = () => {
                                this.loadBrands();
                                this.loadProducts();
                            }

                            loadBrands = () => {
                                EShopService.fetchBrands()
                                    .then((data) => {
                                        this.setState({
                                            brands: data.data
                                        })
                                    });
                            }

                            deleteProduct = (id) => {
                                EShopService.deleteProduct(id)
                                    .then(() => {
                                        this.loadProducts();
                                    });
                            }

                            addProduct = (id, name, year, brand) => {
                                EShopService.addProduct(id, name, year, brand)
                                    .then(() => {
                                        this.loadProducts();
                                    });
                            }

                            addBrand = (id, name, since) => {
                                EShopService.addProduct(id, name, since)
                                    .then(() => {
                                        this.loadBrandss();
                                    });
                            }



                            loadProducts = () => {
                                EShopService.fetchProducts()
                                    .then((data) => {
                                        this.setState({
                                            products: data.data
                                        })
                                    });
                            }

                        }

                        export default App;
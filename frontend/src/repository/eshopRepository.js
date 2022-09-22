import axios from '../custom-axios/axios';

const EShopService = {

    fetchProducts: () => {
        return axios.get("/products");
    },
    getProduct: (id) => {
        return axios.get(`/products/${id}`);
    },
    deleteProduct: (id) => {
        return axios.delete(`/products/delete/${id}`);
    },
    fetchBrands: () => {
        return axios.get("/brands");
    },
    login: (user_username, user_password) => {
        return axios.post("/login", {
            "user_username": user_username,
            "user_password": user_password
        });
    },

    addProduct: (id, name, year, brand) => {
        return axios.post("/products/add", {
            "id": id,
            "name": name,
            "year": year,
            "brand": brand
        });
    },

    addBrand: (id, name, since) => {
        return axios.post("/brands/add", {
            "id": id,
            "name": name,
            "since": since,
        });
    }


}

export default EShopService;
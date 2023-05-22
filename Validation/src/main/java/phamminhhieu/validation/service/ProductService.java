package phamminhhieu.validation.service;

import org.springframework.stereotype.Service;
import phamminhhieu.validation.model.Product;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private List<Product> listProduct = new ArrayList<>();

    public ProductService() {
    }

    public void add(Product newProduct) {
        listProduct.add(newProduct);
    }

    public List<Product> getAll() {
        return listProduct;
    }

    public Product get(int id){
        return listProduct.stream().filter(product -> product.getId() == id).findFirst().orElse(null);
    }

    public void edit(Product editProduct){
        Product productEdit = get(editProduct.getId());
        productEdit.setName(editProduct.getName());
        productEdit.setImage(editProduct.getImage());
        productEdit.setPrice(editProduct.getPrice());
    }
}

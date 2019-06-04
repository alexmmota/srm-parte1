package br.com.srm.service;

import br.com.srm.exception.BusinessServiceException;
import br.com.srm.model.ProductEntity;
import br.com.srm.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductService {

    private static Logger logger = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public ProductEntity save(ProductEntity product) {
        logger.info("m=save, product={}", product);
        if (productRepository.findByIsbn(product.getIsbn()) != null)
            throw new BusinessServiceException("Já existe um produto com esse codigo ISBN");
        return productRepository.save(product);
    }

    public void delete(String isbn) {
        logger.info("m=delete, isbn={}", isbn);
        productRepository.deleteById(isbn);
    }

    public ProductEntity addAmount(String isbn, Integer amount) {
        logger.info("m=addAmount, isbn={}, amount={}", isbn, amount);
        ProductEntity product = findByISBN(isbn);
        product.setAmount(product.getAmount() + amount);
        return productRepository.save(product);
    }

    public ProductEntity subtractAmount(String isbn, Integer amount) {
        logger.info("m=subtractAmount, isbn={}, amount={}", isbn, amount);
        ProductEntity product = findByISBN(isbn);
        if (product.getAmount() < amount)
            throw new BusinessServiceException("Quantidade não está disponível no estoque");
        product.setAmount(product.getAmount() - amount);
        return productRepository.save(product);
    }

    public ProductEntity findByISBN(String isbn) {
        Optional<ProductEntity> product = productRepository.findById(isbn);
        if (product.isPresent())
            return product.get();
        return null;
    }

}

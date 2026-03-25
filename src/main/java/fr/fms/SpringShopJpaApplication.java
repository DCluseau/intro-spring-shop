package fr.fms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.fms.dao.ArticleRepository;
import fr.fms.dao.CategoryRepository;
import fr.fms.entities.Article;
import fr.fms.entities.Category;

@SpringBootApplication
public class SpringShopJpaApplication implements CommandLineRunner {
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ArticleRepository articleRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringShopJpaApplication.class, args);
	}
	
	@Override
	public void run(String...args) throws Exception{
		/*
		 * Create categories and articles
		 */
//		categoryRepository.save(new Category("Smartphone"));
//		articleRepository.save(new Article("Samsung", "S9", 250));
//		Category smartphone = categoryRepository.save(new Category("Smartphone"));
//		Category tablet = categoryRepository.save(new Category("Tablet"));
//		Category pc = categoryRepository.save(new Category("PC"));
//		
//		articleRepository.save(new Article("Samsung", "S10", 500, smartphone));
//		articleRepository.save(new Article("Samsung", "S9", 350, smartphone));
//		articleRepository.save(new Article("Xiaomi", "MI10", 100, smartphone));
//		
//		articleRepository.save(new Article("Samsung", "GalaxyTab", 450, tablet));
//		articleRepository.save(new Article("Apple", "Ipad", 450, tablet));
//		
//		articleRepository.save(new Article("Asus", "R510", 600, pc));
		
		/*
		 * Find an article by category id
		 */
		for(Article article : articleRepository.findByCategoryId(3L)) {
			System.out.println(article);
		}
		/*
		 * Find an article by description
		 */
		for(Article article : articleRepository.findByDescription("Ipad")) {
			System.out.println(article);
		}
		/*
		 * Find an article which description contains a given word
		 */
		for(Article article : articleRepository.findByDescriptionContains("pad")) {
			System.out.println(article);
		}
		/*
		 * Select all articles
		 */
		for(Article article : articleRepository.findAll()) {
			System.out.println(article);
		}
		/*
		 * Find an article by description and brand
		 */
		for(Article article : articleRepository.findByDescriptionAndBrand("R510", "Asus")) {
			System.out.println(article);
		}
		
		/*
		 * Delete article by its id
		 * An article is created before being deleted for the demo
		 */
		Category tablet = categoryRepository.findById(4L).get();
		Article toDelete = new Article("Apple", "Ipad", 450, tablet);
		articleRepository.save(toDelete);
		articleRepository.deleteById(toDelete.getId());
		
		/*
		 * Update an article with its id
		 */
		Article toUpdate = articleRepository.findById(6L).get();
		toUpdate.setPrice(150);
		articleRepository.save(toUpdate);
		
		/*
		 * Display categories by name ascending
		 */
		for(Category category : categoryRepository.findByOrderByNameAsc()){
			System.out.println(category);
		}
		
		/*
		 * Display categories by name descending
		 */
		for(Category category : categoryRepository.findByOrderByNameDesc()){
			System.out.println(category);
		}
		
		/*
		 * Find category by name
		 */
		for(Category category : categoryRepository.findByName("PC")) {
			System.out.println(category);
		}
		/*
		 * Tried to search an Article by using "searchArticles"
		 */
//		for(Article article : articleRepository.searchArticles("sung", 250)) {
//			System.out.println(article);
//		}
	}

}

public class RecipeBuilder {
    public Recipe build(Product[] products, int[] amounts, String result) {
        if(products.length != amounts.length) {
            throw new IllegalArgumentException("input lengths are different");
        }
        Recipe r = new Recipe();
        for(int i = 0; i < products.length; i++) {
            r.addProduct(products[i]);
            r.addAmount(amounts[i]);
        }
        r.setResult(result);
        return r;
    }

    public Recipe build(String result) {
        Recipe r = new Recipe();
        r.setResult(result);
        return r;
    }
}

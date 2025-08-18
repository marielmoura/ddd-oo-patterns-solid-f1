@FunctionalInterface
public interface Especificacao<T> {
	boolean isSatisfeitaPor(T t);

	default Especificacao<T> e(Especificacao<T> outra) {
		return (t) -> this.isSatisfeitaPor(t) && outra.isSatisfeitaPor(t);
	}

	default Especificacao<T> ou(Especificacao<T> outra) {
		return (t) -> this.isSatisfeitaPor(t) || outra.isSatisfeitaPor(t);
	}
}

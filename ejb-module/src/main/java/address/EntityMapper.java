package address;


public interface EntityMapper<E,D> {

    D entityToDto(E source);
    E dtoToEntity(D destination);

}

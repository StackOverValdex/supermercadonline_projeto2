package repository;

import DAL.ARMAZEM;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface ARMAZEMRepository extends JpaRepository<ARMAZEM, String>, JpaSpecificationExecutor<ARMAZEM>
{
    @Override
    default List<ARMAZEM> findAll()
    {
        return null;
    }

    @Override
    default List<ARMAZEM> findAll(Sort sort) {
        return null;
    }

    @Override
    default List<ARMAZEM> findAllById(Iterable<String> iterable)
    {
        return null;
    }

    @Override
    default <S extends ARMAZEM> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    default void flush() {

    }

    @Override
    default <S extends ARMAZEM> S saveAndFlush(S s) {
        return null;
    }

    @Override
    default void deleteInBatch(Iterable<ARMAZEM> iterable) {

    }

    @Override
    default void deleteAllInBatch() {

    }

    @Override
    default ARMAZEM getOne(String s) {
        return null;
    }

    @Override
    default <S extends ARMAZEM> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    default <S extends ARMAZEM> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    default Optional<ARMAZEM> findOne(Specification<ARMAZEM> specification) {
        return Optional.empty();
    }

    @Override
    default List<ARMAZEM> findAll(Specification<ARMAZEM> specification) {
        return null;
    }

    @Override
    default Page<ARMAZEM> findAll(Specification<ARMAZEM> specification, Pageable pageable) {
        return null;
    }

    @Override
    default List<ARMAZEM> findAll(Specification<ARMAZEM> specification, Sort sort) {
        return null;
    }

    @Override
    default long count(Specification<ARMAZEM> specification) {
        return 0;
    }

    @Override
    default Page<ARMAZEM> findAll(Pageable pageable) {
        return null;
    }

    @Override
    default <S extends ARMAZEM> S save(S s) {
        return null;
    }

    @Override
    default Optional<ARMAZEM> findById(String s) {
        return Optional.empty();
    }

    @Override
    default boolean existsById(String s) {
        return false;
    }

    @Override
    default long count() {
        return 0;
    }

    @Override
    default void deleteById(String s) {

    }

    @Override
    default void delete(ARMAZEM armazem) {

    }

    @Override
    default void deleteAll(Iterable<? extends ARMAZEM> iterable) {

    }

    @Override
    default void deleteAll() {

    }

    @Override
    default <S extends ARMAZEM> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    default <S extends ARMAZEM> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    default <S extends ARMAZEM> long count(Example<S> example) {
        return 0;
    }

    @Override
    default <S extends ARMAZEM> boolean exists(Example<S> example) {
        return false;
    }
}
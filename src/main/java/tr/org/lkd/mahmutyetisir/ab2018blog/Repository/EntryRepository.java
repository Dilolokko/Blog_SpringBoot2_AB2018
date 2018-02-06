package tr.org.lkd.mahmutyetisir.ab2018blog.Repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tr.org.lkd.mahmutyetisir.ab2018blog.model.Entry;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional
public interface EntryRepository extends CrudRepository<Entry, Integer>{

    @Query("SELECT e FROM Entry e")
    List<Entry> findAllEntries();

    @Query("select e from Entry e where id = :id")
    Entry findEntryById(@Param("id") Integer id);

    @Modifying
    @Query("delete from Entry where id = :id")
    void deleteEntryById(@Param("id") Integer id);

    @Query("select e from Entry e where title like %:title%")
    List<Entry> findByTitle(@Param("title") String title);

    List<Entry> findByCreateDate(LocalDate date);
}

package his.department.surgical.db.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;


@Entity
@Table(name = "datetime")
@IdClass(DatetimeEntity.class)
public class DatetimeEntity implements Serializable {

    @Id
    @Column(name = "date", nullable = false)
    private Date date;

    @Id
    @Column(name = "time", nullable = false)
    private Time time;

    public DatetimeEntity() {}

    public Date getDate() {
        return date;
    }

    public Time getTime() {
        return time;
    }

    @Override
    public String toString() {
        return date + " " + time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DatetimeEntity that)) return false;

        if (!getDate().equals(that.getDate())) return false;
        return getTime().equals(that.getTime());
    }

    @Override
    public int hashCode() {
        int result = getDate().hashCode();
        result = 31 * result + getTime().hashCode();
        return result;
    }
}

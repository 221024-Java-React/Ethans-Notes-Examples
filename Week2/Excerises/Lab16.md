# Follow the directions below to complete the SQL Lab

# In DBeaver create a new database called Labs with appropriate user and password
## Make a connection to the new database to complete the following labs

# Using DDL create a new Table called `songs` with the following columns:

```
id primary key
name varchar not null
artist varchar not null
album varchar not null
genre varchar not null
duration decimal
fav boolean
```

# Using DML insert the following data into the `songs` table


| id | name 	               | artist 	      | album 	         | genre   | duration | fav |
|----|------	               |--------	      |-------	         |-------  |----------|-----| 
| 1  | Heart-Shaped Box        | Nirvana          | In Utero         | Rock    | 4.68     | f   |
| 2  | Smells Like Teen Spirit | Nirvana          | Nevermind        | Rock    | 3.65     | f   |
| 3  | Higher                  | Creed            | Human Clay       | Rock    | 5.43     | f   |
| 4  | Hero                    | Skillet          | Awake            | Rock    | 3.12     | f   |
| 5  | Hotel California        | Eagles           | Hotel California | Rock    | 3.47     | f   |
| 6  | Austin                  | Blake Shelton    | Black Shelton    | Country | 3.83     | f   |
| 7  | Dirt Road Anthem        | Jason Aldean     | My Kinda Party   | Country | 3.81     | f   |
| 8  | Springsteen             | Eric Church      | Chief            | Country | 4.38     | f   |
| 9  | Watching Airplanes      | Gary Allen       | Living Hard      | Country | 4.05     | f   |
| 10 | Hey Girl                | Billy Currington | We Are Tonight   | Country | 3.35     | f   |
| 11 | A Milli                 | Lil Wayne        | Tha Carter III   | Hip Hop | 3.70     | f   |
| 12 | Over                    | Drake            | Thank Me Later   | Hip Hop | 3.90     | f   |
| 13 | No Interuption          | Hoodie Allen     | All American     | Hip Hop | 3.58     | f   |
| 14 | It Girl                 | Jason Derulo     | Future History   | Hip Hop | 3.20     | f   |
| 15 | Frick Park Market       | Mac Miller       | Blue Slide Park  | Hip Hop | 3.30     | f   |

# Using DML select and return all songs from the table

## When complete, save the sql script as `Lab16.sql` and push the file up to your Github
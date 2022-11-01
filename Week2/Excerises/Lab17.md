# Using the table from the previous lab with following data:

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

# Complete the following challenges with DQL in a file called Lab17.sql

## Part 1: Write the correct SQL statements to accomplish the following:

1. Select all the data about the song called `Austin`
2. Select only the artists of Country songs (Only select the artist column of the songs table)
3. Select only the names of hip hop songs longer than 3.5 minutes
4. Select all the data about songs that start with the letter 'H'
5. Select all the data about songs that are the Country genre, and are sang by an artist whos last name is 'Allen'

## Write the correct SQL statements to update songs that are favorites according to Ethan:

1. Ethan loves any song in the Hip Hop Genre, update the fav column of all of these songs
2. Ethan loves Rock songs by the artist Nirvana, update the fav column of all of these songs
3. Ethan loves the songs Austin and Springsteen, update the fav column of all of these songs

## Write the correct SQL statements to delete the songs, until only Ethans favorite song from the table is left

1. Delete all songs which are not on of Ethan's favorites
2. Ethan is not really feeling Country right now, delete all songs of the Country genre
3. Ethan has a short attention span, delete all songs which are longer than 3.5 minutes
4. Ethan's favorite artist is not Jason Derulo, remove the songs by that artist

## When complete, save the sql script as `Lab17.sql` and push the file up to your Github
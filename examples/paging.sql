

SELECT * FROM tracks
LIMIT 10
OFFSET 20;

SELECT * FROM tracks
ORDER BY tracks.Milliseconds
LIMIT 10
OFFSET 20;

SELECT * FROM tracks
ORDER BY
         tracks.Milliseconds DESC,
         tracks.Name
LIMIT 10
OFFSET 20;

SELECT TrackId,Name, Composer
FROM
    tracks
ORDER BY
    Composer;

SELECT TrackId,Name, Composer
FROM
    tracks
ORDER BY
    Composer NULLS LAST;

EXPLAIN QUERY PLAN
    SELECT TrackId,Name, Composer
FROM
    tracks
ORDER BY
    Composer DESC NULLS LAST;

CREATE INDEX
    track_composers
    ON tracks (Composer);

EXPLAIN QUERY PLAN
SELECT EmployeeId, LastName, FirstName, HireDate
FROM employees
WHERE HireDate > (SELECT AVG(HireDate) FROM employees);

EXPLAIN QUERY PLAN
SELECT tracks.Name AS TrackName, artists.Name AS Artist, albums.Title AS AlbumTitle,

       tracks.Milliseconds as TrackLength
FROM tracks
         JOIN albums on tracks.AlbumId = albums.AlbumId
         JOIN artists on albums.ArtistId = artists.ArtistId
WHERE TrackLength > 360000;

EXPLAIN QUERY PLAN
SELECT main.employees.FirstName as FirstName,
       main.employees.EmployeeId as EmployeeId,
       bosses.FirstName as BossFirstName,
       bosses.EmployeeId as BossEmployeeId
FROM main.employees
         JOIN main.employees AS bosses ON main.employees.ReportsTo = bosses.EmployeeId;
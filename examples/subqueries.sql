SELECT name FROM tracks
WHERE AlbumId=(SELECT AlbumId from albums WHERE Title="Machine Head");

SELECT AlbumId, Title from albums WHERE Title LIKE "A%";

SELECT name FROM tracks
WHERE AlbumId=(SELECT AlbumId from albums WHERE Title LIKE "A%");


SELECT name FROM tracks
WHERE AlbumId IN (SELECT AlbumId from albums WHERE Title LIKE "A%");

-- Select all albums with a total size over 1Mb
SELECT title
FROM albums
WHERE 10000000 > (SELECT SUM(bytes)
    FROM tracks
WHERE tracks.AlbumId = albums.AlbumId) ;


SELECT * FROM artists
WHERE artists.Name LIKE 'A%';


SELECT artists.Name, count(DISTINCT a.AlbumId) as AlbumCount, count(TrackId) AS TrackCount
FROM artists
    JOIN albums a ON artists.ArtistId = a.ArtistId
    JOIN tracks t ON a.AlbumId = t.AlbumId
GROUP BY a.ArtistId
HAVING AlbumCount > 2;

SELECT artists.Name, count(DISTINCT a.AlbumId) as AlbumCount FROM artists JOIN albums a ON artists.ArtistId = a.ArtistId GROUP BY a.ArtistId HAVING AlbumCount > 1


SELECT SUM(bytes)
FROM tracks
WHERE tracks.AlbumId = 1;

-- Denormalized query
SELECT title
FROM albums
WHERE 10000000 > albums.bytes;

-- Move condition into subquery
SELECT Name from artists where
ArtistId IN
(SELECT albums.ArtistId
FROM albums
WHERE albums.AlbumId IN
      (SELECT AlbumId FROM tracks
       GROUP BY AlbumId
    HAVING  10000000 > SUM(tracks.Bytes)));

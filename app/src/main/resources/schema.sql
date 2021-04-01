CREATE TABLE tasks (
    id SERIAL PRIMARY KEY,
    context TEXT CHECK (
        (context = 'LIVE') or 
        (context = 'LEARN') or 
        (context = 'EARN') or 
        (context = 'LOVE')
    ),
    name TEXT NOT NULL
);
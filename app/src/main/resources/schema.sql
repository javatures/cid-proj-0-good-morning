CREATE TABLE tasks (
    id SERIAL PRIMARY KEY,
    context TEXT CHECK (
        (context = 'LIVE') or 
        (context = 'LEARN') or 
        (context = 'EARN') or 
        (context = 'LOVE') or
        (context = 'ALL')
    ),
    name text NOT NULL,
    priority TEXT CHECK (
        (priority = 'TOP OF MIND') or
        (priority = 'FRONT AND CENTER') or
        (priority = 'BOTTOM LINE')
    )
);

INSERT INTO tasks (context,name,priority)
    VALUES 
        ('LIVE','Run daily!','TOP OF MIND'),
        ('LOVE','Quality time with family/friends','TOP OF MIND'),
        ('LEARN','Revature: Project 0','TOP OF MIND'),
        ('EARN','Taxes...','TOP OF MIND'),
        ('ALL','How PRESENT were you today?','BOTTOM LINE');
CREATE TABLE tasks (
    id SERIAL PRIMARY KEY,
    context TEXT CHECK (
        (context = 'LIVE') or 
        (context = 'LEARN') or 
        (context = 'EARN') or 
        (context = 'LOVE') or
        (context = '')
    ),
    name text NOT NULL,
    priority TEXT CHECK (
        (priority = 'TOP OF MIND') or
        (priority = '')
    )
);

INSERT INTO tasks (context,name,priority)
    VALUES 
        ('LIVE','Personal Task (not pressing)',''),
        ('LIVE','Personal Task','TOP OF MIND'),
        ('LEARN','Work Task (not pressing)',''),
        ('LEARN','Work Task','TOP OF MIND'),
        ('EARN','Financial Task (not pressing)',''),
        ('EARN','Financial Task','TOP OF MIND'),
        ('LOVE','Enlightenment Task (not pressing)',''),
        ('LOVE','Enlightenment Task','TOP OF MIND');
-- create a user to which we will grant/revoke priveleges
create user intern2 with password 'password';

-- granting select priveleges to intern2:
grant select on animals to intern2;

-- removing insertion priveleges from intern2
revoke insert on animals from intern2;
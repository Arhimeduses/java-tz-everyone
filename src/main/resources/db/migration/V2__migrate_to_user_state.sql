CREATE TYPE family_states AS ENUM('NOT_MARRIED', 'MARRIED', 'HAS_GIRLFRIEND');

ALTER TABLE customer
    ALTER COLUMN family_state
          TYPE family_states
            USING state::family_states;
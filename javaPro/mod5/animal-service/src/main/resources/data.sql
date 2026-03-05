INSERT INTO
    animal (nome_provisorio,
            idade_estimada,
            raca,
            data_entrada,
            condicoes_chegada,
            nome_recebedor,
            porte,
            data_obito,
            data_adocao)
VALUES
    ('Cachorrinho primeiro',
     3,
     'SRD',
     CURRENT_DATE,
     'Sujo, sem pulgas ou carrapatos',
     'Marcello',
     'Grande',
     null,
     null);

INSERT INTO
    animal (nome_provisorio,
            idade_estimada,
            raca,
            data_entrada,
            condicoes_chegada,
            nome_recebedor,
            porte,
            data_obito,
            data_adocao)
VALUES
    ('Cachorrinho segundo',
     13,
     'pintcher',
     CURRENT_DATE,
     'Na FORÇA do ódio',
     'Marcello',
     'Pequeno',
     null,
     null);

-- 5 Animais COM data de adoção
INSERT INTO animal (nome_provisorio, idade_estimada, raca, data_entrada, condicoes_chegada, nome_recebedor, porte, data_obito, data_adocao)
VALUES ('Rex', 3, 'Vira-lata', '2025-01-10', 'Magro, mas dócil', 'Marcello', 'Médio', null, '2025-02-15');

INSERT INTO animal (nome_provisorio, idade_estimada, raca, data_entrada, condicoes_chegada, nome_recebedor, porte, data_obito, data_adocao)
VALUES ('Mimi', 2, 'Siamês', '2025-05-20', 'Saudável', 'Ana Paula', 'Pequeno', null, '2025-06-01');

INSERT INTO animal (nome_provisorio, idade_estimada, raca, data_entrada, condicoes_chegada, nome_recebedor, porte, data_obito, data_adocao)
VALUES ('Thor', 5, 'Golden Retriever', '2024-12-01', 'Pelo embaraçado', 'Marcello', 'Grande', null, '2024-12-25');

INSERT INTO animal (nome_provisorio, idade_estimada, raca, data_entrada, condicoes_chegada, nome_recebedor, porte, data_obito, data_adocao)
VALUES ('Luna', 1, 'Persa', '2026-01-15', 'Assustada', 'Beatriz', 'Pequeno', null, '2026-02-10');

INSERT INTO animal (nome_provisorio, idade_estimada, raca, data_entrada, condicoes_chegada, nome_recebedor, porte, data_obito, data_adocao)
VALUES ('Baleia', 4, 'Labrador', '2025-08-10', 'Muito dócil', 'Marcello', 'Grande', null, '2025-09-20');

-- 5 Animais SEM data de adoção (incluindo 2 com óbito)
INSERT INTO animal (nome_provisorio, idade_estimada, raca, data_entrada, condicoes_chegada, nome_recebedor, porte, data_obito, data_adocao)
VALUES ('Soneca', 10, 'SRD - Gato', '2026-02-01', 'Desidratado', 'Ana Paula', 'Pequeno', '2026-02-15', null);

INSERT INTO animal (nome_provisorio, idade_estimada, raca, data_entrada, condicoes_chegada, nome_recebedor, porte, data_obito, data_adocao)
VALUES ('Feroz', 8, 'Pastor Alemão', '2026-03-01', 'Ferimento na pata', 'Marcello', 'Grande', '2026-03-04', null);

INSERT INTO animal (nome_provisorio, idade_estimada, raca, data_entrada, condicoes_chegada, nome_recebedor, porte, data_obito, data_adocao)
VALUES ('Mingau', 1, 'Branco comum', '2026-02-20', 'Ótimas condições', 'Beatriz', 'Pequeno', null, null);

INSERT INTO animal (nome_provisorio, idade_estimada, raca, data_entrada, condicoes_chegada, nome_recebedor, porte, data_obito, data_adocao)
VALUES ('Pipoca', 2, 'Poodle', '2026-03-02', 'Muito agitada', 'Marcello', 'Pequeno', null, null);

INSERT INTO animal (nome_provisorio, idade_estimada, raca, data_entrada, condicoes_chegada, nome_recebedor, porte, data_obito, data_adocao)
VALUES ('Garfield', 6, 'Laranja Tabby', '2026-01-10', 'Obeso', 'Ana Paula', 'Médio', null, null);
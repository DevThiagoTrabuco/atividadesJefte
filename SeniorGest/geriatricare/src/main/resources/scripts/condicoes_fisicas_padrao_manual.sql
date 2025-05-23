INSERT INTO condicoes_fisicas (condicoes_fisicas_id, condicoes_fisicas_nome, condicoes_fisicas_descricao)
SELECT 1, 'Acamado', 'Paciente que está acamado e necessita de cuidados especiais'
WHERE NOT EXISTS (SELECT 1 FROM condicoes_fisicas WHERE condicoes_fisicas_id = 1 OR condicoes_fisicas_nome = 'Acamado');

INSERT INTO condicoes_fisicas (condicoes_fisicas_id, condicoes_fisicas_nome, condicoes_fisicas_descricao)
SELECT 2, 'Alzheimer', 'Paciente com diagnóstico de Alzheimer'
WHERE NOT EXISTS (SELECT 1 FROM condicoes_fisicas WHERE condicoes_fisicas_id = 2 OR condicoes_fisicas_nome = 'Alzheimer');

INSERT INTO condicoes_fisicas (condicoes_fisicas_id, condicoes_fisicas_nome, condicoes_fisicas_descricao)
SELECT 3, 'Artrite', 'Paciente com inflamação nas articulações'
WHERE NOT EXISTS (SELECT 1 FROM condicoes_fisicas WHERE condicoes_fisicas_id = 3 OR condicoes_fisicas_nome = 'Artrite');

INSERT INTO condicoes_fisicas (condicoes_fisicas_id, condicoes_fisicas_nome, condicoes_fisicas_descricao)
SELECT 4, 'Demência', 'Paciente com declínio cognitivo progressivo'
WHERE NOT EXISTS (SELECT 1 FROM condicoes_fisicas WHERE condicoes_fisicas_id = 4 OR condicoes_fisicas_nome = 'Demência');

INSERT INTO condicoes_fisicas (condicoes_fisicas_id, condicoes_fisicas_nome, condicoes_fisicas_descricao)
SELECT 5, 'Diabetes', 'Paciente com diabetes tipo 1 ou 2'
WHERE NOT EXISTS (SELECT 1 FROM condicoes_fisicas WHERE condicoes_fisicas_id = 5 OR condicoes_fisicas_nome = 'Diabetes');

INSERT INTO condicoes_fisicas (condicoes_fisicas_id, condicoes_fisicas_nome, condicoes_fisicas_descricao)
SELECT 6, 'DPOC', 'Doença pulmonar obstrutiva crônica'
WHERE NOT EXISTS (SELECT 1 FROM condicoes_fisicas WHERE condicoes_fisicas_id = 6 OR condicoes_fisicas_nome = 'DPOC');

INSERT INTO condicoes_fisicas (condicoes_fisicas_id, condicoes_fisicas_nome, condicoes_fisicas_descricao)
SELECT 7, 'Depressão', 'Paciente com sintomas depressivos'
WHERE NOT EXISTS (SELECT 1 FROM condicoes_fisicas WHERE condicoes_fisicas_id = 7 OR condicoes_fisicas_nome = 'Depressão');

INSERT INTO condicoes_fisicas (condicoes_fisicas_id, condicoes_fisicas_nome, condicoes_fisicas_descricao)
SELECT 8, 'Hipertensão', 'Paciente com pressão arterial elevada'
WHERE NOT EXISTS (SELECT 1 FROM condicoes_fisicas WHERE condicoes_fisicas_id = 8 OR condicoes_fisicas_nome = 'Hipertensão');

INSERT INTO condicoes_fisicas (condicoes_fisicas_id, condicoes_fisicas_nome, condicoes_fisicas_descricao)
SELECT 9, 'Insuficiência cardíaca', 'Paciente com função cardíaca comprometida'
WHERE NOT EXISTS (SELECT 1 FROM condicoes_fisicas WHERE condicoes_fisicas_id = 9 OR condicoes_fisicas_nome = 'Insuficiência cardíaca');

INSERT INTO condicoes_fisicas (condicoes_fisicas_id, condicoes_fisicas_nome, condicoes_fisicas_descricao)
SELECT 10, 'Osteoporose', 'Paciente com perda de densidade óssea'
WHERE NOT EXISTS (SELECT 1 FROM condicoes_fisicas WHERE condicoes_fisicas_id = 10 OR condicoes_fisicas_nome = 'Osteoporose');

INSERT INTO condicoes_fisicas (condicoes_fisicas_id, condicoes_fisicas_nome, condicoes_fisicas_descricao)
SELECT 11, 'Paralisia', 'Paciente com perda parcial ou total de movimento'
WHERE NOT EXISTS (SELECT 1 FROM condicoes_fisicas WHERE condicoes_fisicas_id = 11 OR condicoes_fisicas_nome = 'Paralisia');

INSERT INTO condicoes_fisicas (condicoes_fisicas_id, condicoes_fisicas_nome, condicoes_fisicas_descricao)
SELECT 12, 'Parkinson', 'Paciente com doença de Parkinson'
WHERE NOT EXISTS (SELECT 1 FROM condicoes_fisicas WHERE condicoes_fisicas_id = 12 OR condicoes_fisicas_nome = 'Parkinson');

INSERT INTO condicoes_fisicas (condicoes_fisicas_id, condicoes_fisicas_nome, condicoes_fisicas_descricao)
SELECT 13, 'Incontinência urinária', 'Paciente com perda involuntária de urina'
WHERE NOT EXISTS (SELECT 1 FROM condicoes_fisicas WHERE condicoes_fisicas_id = 13 OR condicoes_fisicas_nome = 'Incontinência urinária');

INSERT INTO condicoes_fisicas (condicoes_fisicas_id, condicoes_fisicas_nome, condicoes_fisicas_descricao)
SELECT 14, 'Cegueira', 'Paciente com perda total da visão'
WHERE NOT EXISTS (SELECT 1 FROM condicoes_fisicas WHERE condicoes_fisicas_id = 14 OR condicoes_fisicas_nome = 'Cegueira');

INSERT INTO condicoes_fisicas (condicoes_fisicas_id, condicoes_fisicas_nome, condicoes_fisicas_descricao)
SELECT 15, 'Surdez', 'Paciente com perda total da audição'
WHERE NOT EXISTS (SELECT 1 FROM condicoes_fisicas WHERE condicoes_fisicas_id = 15 OR condicoes_fisicas_nome = 'Surdez');

INSERT INTO condicoes_fisicas (condicoes_fisicas_id, condicoes_fisicas_nome, condicoes_fisicas_descricao)
SELECT 16, 'Asma', 'Paciente com doença respiratória crônica'
WHERE NOT EXISTS (SELECT 1 FROM condicoes_fisicas WHERE condicoes_fisicas_id = 16 OR condicoes_fisicas_nome = 'Asma');

INSERT INTO condicoes_fisicas (condicoes_fisicas_id, condicoes_fisicas_nome, condicoes_fisicas_descricao)
SELECT 17, 'Epilepsia', 'Paciente com crises epilépticas'
WHERE NOT EXISTS (SELECT 1 FROM condicoes_fisicas WHERE condicoes_fisicas_id = 17 OR condicoes_fisicas_nome = 'Epilepsia');

INSERT INTO condicoes_fisicas (condicoes_fisicas_id, condicoes_fisicas_nome, condicoes_fisicas_descricao)
SELECT 18, 'Câncer', 'Paciente em tratamento oncológico'
WHERE NOT EXISTS (SELECT 1 FROM condicoes_fisicas WHERE condicoes_fisicas_id = 18 OR condicoes_fisicas_nome = 'Câncer');

INSERT INTO condicoes_fisicas (condicoes_fisicas_id, condicoes_fisicas_nome, condicoes_fisicas_descricao)
SELECT 19, 'HIV', 'Paciente com HIV/AIDS'
WHERE NOT EXISTS (SELECT 1 FROM condicoes_fisicas WHERE condicoes_fisicas_id = 19 OR condicoes_fisicas_nome = 'HIV');

INSERT INTO condicoes_fisicas (condicoes_fisicas_id, condicoes_fisicas_nome, condicoes_fisicas_descricao)
SELECT 20, 'Lesão medular', 'Paciente com lesão na medula espinhal'
WHERE NOT EXISTS (SELECT 1 FROM condicoes_fisicas WHERE condicoes_fisicas_id = 20 OR condicoes_fisicas_nome = 'Lesão medular');

INSERT INTO condicoes_fisicas (condicoes_fisicas_id, condicoes_fisicas_nome, condicoes_fisicas_descricao)
SELECT 21, 'Síndrome de Down', 'Paciente com Síndrome de Down'
WHERE NOT EXISTS (SELECT 1 FROM condicoes_fisicas WHERE condicoes_fisicas_id = 21 OR condicoes_fisicas_nome = 'Síndrome de Down');

INSERT INTO condicoes_fisicas (condicoes_fisicas_id, condicoes_fisicas_nome, condicoes_fisicas_descricao)
SELECT 22, 'Obesidade', 'Paciente com excesso de peso'
WHERE NOT EXISTS (SELECT 1 FROM condicoes_fisicas WHERE condicoes_fisicas_id = 22 OR condicoes_fisicas_nome = 'Obesidade');

INSERT INTO condicoes_fisicas (condicoes_fisicas_id, condicoes_fisicas_nome, condicoes_fisicas_descricao)
SELECT 23, 'Osteoartrite', 'Paciente com osteoartrite'
WHERE NOT EXISTS (SELECT 1 FROM condicoes_fisicas WHERE condicoes_fisicas_id = 23 OR condicoes_fisicas_nome = 'Osteoartrite');

INSERT INTO condicoes_fisicas (condicoes_fisicas_id, condicoes_fisicas_nome, condicoes_fisicas_descricao)
SELECT 24, 'Insuficiência renal', 'Paciente com insuficiência renal crônica'
WHERE NOT EXISTS (SELECT 1 FROM condicoes_fisicas WHERE condicoes_fisicas_id = 24 OR condicoes_fisicas_nome = 'Insuficiência renal');

INSERT INTO condicoes_fisicas (condicoes_fisicas_id, condicoes_fisicas_nome, condicoes_fisicas_descricao)
SELECT 25, 'Anemia', 'Paciente com níveis baixos de hemoglobina'
WHERE NOT EXISTS (SELECT 1 FROM condicoes_fisicas WHERE condicoes_fisicas_id = 25 OR condicoes_fisicas_nome = 'Anemia');

INSERT INTO condicoes_fisicas (condicoes_fisicas_id, condicoes_fisicas_nome, condicoes_fisicas_descricao)
SELECT 26, 'Hepatite', 'Paciente com inflamação no fígado'
WHERE NOT EXISTS (SELECT 1 FROM condicoes_fisicas WHERE condicoes_fisicas_id = 26 OR condicoes_fisicas_nome = 'Hepatite');

INSERT INTO condicoes_fisicas (condicoes_fisicas_id, condicoes_fisicas_nome, condicoes_fisicas_descricao)
SELECT 27, 'Doença de Alzheimer avançada', 'Paciente em estágio avançado de Alzheimer'
WHERE NOT EXISTS (SELECT 1 FROM condicoes_fisicas WHERE condicoes_fisicas_id = 27 OR condicoes_fisicas_nome = 'Doença de Alzheimer avançada');

INSERT INTO condicoes_fisicas (condicoes_fisicas_id, condicoes_fisicas_nome, condicoes_fisicas_descricao)
SELECT 28, 'Traumatismo craniano', 'Paciente com lesão cerebral traumática'
WHERE NOT EXISTS (SELECT 1 FROM condicoes_fisicas WHERE condicoes_fisicas_id = 28 OR condicoes_fisicas_nome = 'Traumatismo craniano');

INSERT INTO condicoes_fisicas (condicoes_fisicas_id, condicoes_fisicas_nome, condicoes_fisicas_descricao)
SELECT 29, 'Infarto', 'Paciente com histórico de infarto'
WHERE NOT EXISTS (SELECT 1 FROM condicoes_fisicas WHERE condicoes_fisicas_id = 29 OR condicoes_fisicas_nome = 'Infarto');

INSERT INTO condicoes_fisicas (condicoes_fisicas_id, condicoes_fisicas_nome, condicoes_fisicas_descricao)
SELECT 30, 'Acidente vascular cerebral', 'Paciente com histórico de AVC'
WHERE NOT EXISTS (SELECT 1 FROM condicoes_fisicas WHERE condicoes_fisicas_id = 30 OR condicoes_fisicas_nome = 'Acidente vascular cerebral');

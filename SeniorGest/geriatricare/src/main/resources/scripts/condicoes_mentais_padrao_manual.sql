INSERT INTO condicoes_mentais (condicoes_mentais_id, condicoes_mentais_nome, condicoes_mentais_descricao)
SELECT 1, 'Depressão', 'Transtorno mental caracterizado por tristeza persistente e perda de interesse'
WHERE NOT EXISTS (SELECT 1 FROM condicoes_mentais WHERE condicoes_mentais_id = 1 OR condicoes_mentais_nome = 'Depressão');

INSERT INTO condicoes_mentais (condicoes_mentais_id, condicoes_mentais_nome, condicoes_mentais_descricao)
SELECT 2, 'Ansiedade', 'Estado de preocupação excessiva e medo constante'
WHERE NOT EXISTS (SELECT 1 FROM condicoes_mentais WHERE condicoes_mentais_id = 2 OR condicoes_mentais_nome = 'Ansiedade');

INSERT INTO condicoes_mentais (condicoes_mentais_id, condicoes_mentais_nome, condicoes_mentais_descricao)
SELECT 3, 'Esquizofrenia', 'Transtorno mental grave que afeta a percepção da realidade'
WHERE NOT EXISTS (SELECT 1 FROM condicoes_mentais WHERE condicoes_mentais_id = 3 OR condicoes_mentais_nome = 'Esquizofrenia');

INSERT INTO condicoes_mentais (condicoes_mentais_id, condicoes_mentais_nome, condicoes_mentais_descricao)
SELECT 4, 'Transtorno bipolar', 'Distúrbio com episódios alternados de mania e depressão'
WHERE NOT EXISTS (SELECT 1 FROM condicoes_mentais WHERE condicoes_mentais_id = 4 OR condicoes_mentais_nome = 'Transtorno bipolar');

INSERT INTO condicoes_mentais (condicoes_mentais_id, condicoes_mentais_nome, condicoes_mentais_descricao)
SELECT 5, 'Transtorno obsessivo-compulsivo', 'Caracterizado por pensamentos obsessivos e comportamentos compulsivos'
WHERE NOT EXISTS (SELECT 1 FROM condicoes_mentais WHERE condicoes_mentais_id = 5 OR condicoes_mentais_nome = 'Transtorno obsessivo-compulsivo');

INSERT INTO condicoes_mentais (condicoes_mentais_id, condicoes_mentais_nome, condicoes_mentais_descricao)
SELECT 6, 'Transtorno de estresse pós-traumático', 'Reação a eventos traumáticos com sintomas persistentes'
WHERE NOT EXISTS (SELECT 1 FROM condicoes_mentais WHERE condicoes_mentais_id = 6 OR condicoes_mentais_nome = 'Transtorno de estresse pós-traumático');

INSERT INTO condicoes_mentais (condicoes_mentais_id, condicoes_mentais_nome, condicoes_mentais_descricao)
SELECT 7, 'Demência', 'Declínio progressivo das funções cognitivas'
WHERE NOT EXISTS (SELECT 1 FROM condicoes_mentais WHERE condicoes_mentais_id = 7 OR condicoes_mentais_nome = 'Demência');

INSERT INTO condicoes_mentais (condicoes_mentais_id, condicoes_mentais_nome, condicoes_mentais_descricao)
SELECT 8, 'Autismo', 'Transtorno do desenvolvimento que afeta a comunicação e comportamento'
WHERE NOT EXISTS (SELECT 1 FROM condicoes_mentais WHERE condicoes_mentais_id = 8 OR condicoes_mentais_nome = 'Autismo');

INSERT INTO condicoes_mentais (condicoes_mentais_id, condicoes_mentais_nome, condicoes_mentais_descricao)
SELECT 9, 'Transtorno de déficit de atenção e hiperatividade', 'Caracterizado por desatenção, hiperatividade e impulsividade'
WHERE NOT EXISTS (SELECT 1 FROM condicoes_mentais WHERE condicoes_mentais_id = 9 OR condicoes_mentais_nome = 'Transtorno de déficit de atenção e hiperatividade');

INSERT INTO condicoes_mentais (condicoes_mentais_id, condicoes_mentais_nome, condicoes_mentais_descricao)
SELECT 10, 'Fobia', 'Medo intenso e irracional de objetos ou situações específicas'
WHERE NOT EXISTS (SELECT 1 FROM condicoes_mentais WHERE condicoes_mentais_id = 10 OR condicoes_mentais_nome = 'Fobia');

INSERT INTO condicoes_mentais (condicoes_mentais_id, condicoes_mentais_nome, condicoes_mentais_descricao)
SELECT 11, 'Transtorno alimentar', 'Distúrbios relacionados à alimentação e peso corporal'
WHERE NOT EXISTS (SELECT 1 FROM condicoes_mentais WHERE condicoes_mentais_id = 11 OR condicoes_mentais_nome = 'Transtorno alimentar');

INSERT INTO condicoes_mentais (condicoes_mentais_id, condicoes_mentais_nome, condicoes_mentais_descricao)
SELECT 12, 'Transtorno de personalidade borderline', 'Instabilidade emocional e comportamental'
WHERE NOT EXISTS (SELECT 1 FROM condicoes_mentais WHERE condicoes_mentais_id = 12 OR condicoes_mentais_nome = 'Transtorno de personalidade borderline');

INSERT INTO condicoes_mentais (condicoes_mentais_id, condicoes_mentais_nome, condicoes_mentais_descricao)
SELECT 13, 'Transtorno de personalidade antisocial', 'Comportamento desrespeitoso e violação dos direitos dos outros'
WHERE NOT EXISTS (SELECT 1 FROM condicoes_mentais WHERE condicoes_mentais_id = 13 OR condicoes_mentais_nome = 'Transtorno de personalidade antisocial');

INSERT INTO condicoes_mentais (condicoes_mentais_id, condicoes_mentais_nome, condicoes_mentais_descricao)
SELECT 14, 'Transtorno de ansiedade generalizada', 'Ansiedade persistente e excessiva'
WHERE NOT EXISTS (SELECT 1 FROM condicoes_mentais WHERE condicoes_mentais_id = 14 OR condicoes_mentais_nome = 'Transtorno de ansiedade generalizada');

INSERT INTO condicoes_mentais (condicoes_mentais_id, condicoes_mentais_nome, condicoes_mentais_descricao)
SELECT 15, 'Transtorno do sono', 'Distúrbios relacionados ao sono'
WHERE NOT EXISTS (SELECT 1 FROM condicoes_mentais WHERE condicoes_mentais_id = 15 OR condicoes_mentais_nome = 'Transtorno do sono');

INSERT INTO condicoes_mentais (condicoes_mentais_id, condicoes_mentais_nome, condicoes_mentais_descricao)
SELECT 16, 'Transtorno de adaptação', 'Resposta emocional a um estressor identificável'
WHERE NOT EXISTS (SELECT 1 FROM condicoes_mentais WHERE condicoes_mentais_id = 16 OR condicoes_mentais_nome = 'Transtorno de adaptação');

INSERT INTO condicoes_mentais (condicoes_mentais_id, condicoes_mentais_nome, condicoes_mentais_descricao)
SELECT 17, 'Transtorno dissociativo', 'Desconexão entre pensamentos, identidade, consciência e memória'
WHERE NOT EXISTS (SELECT 1 FROM condicoes_mentais WHERE condicoes_mentais_id = 17 OR condicoes_mentais_nome = 'Transtorno dissociativo');

INSERT INTO condicoes_mentais (condicoes_mentais_id, condicoes_mentais_nome, condicoes_mentais_descricao)
SELECT 18, 'Transtorno de humor', 'Alterações persistentes do humor'
WHERE NOT EXISTS (SELECT 1 FROM condicoes_mentais WHERE condicoes_mentais_id = 18 OR condicoes_mentais_nome = 'Transtorno de humor');

INSERT INTO condicoes_mentais (condicoes_mentais_id, condicoes_mentais_nome, condicoes_mentais_descricao)
SELECT 19, 'Transtorno psicótico breve', 'Episódio breve de sintomas psicóticos'
WHERE NOT EXISTS (SELECT 1 FROM condicoes_mentais WHERE condicoes_mentais_id = 19 OR condicoes_mentais_nome = 'Transtorno psicótico breve');

INSERT INTO condicoes_mentais (condicoes_mentais_id, condicoes_mentais_nome, condicoes_mentais_descricao)
SELECT 20, 'Transtorno delirante', 'Crenças falsas persistentes'
WHERE NOT EXISTS (SELECT 1 FROM condicoes_mentais WHERE condicoes_mentais_id = 20 OR condicoes_mentais_nome = 'Transtorno delirante');

INSERT INTO condicoes_mentais (condicoes_mentais_id, condicoes_mentais_nome, condicoes_mentais_descricao)
SELECT 21, 'Transtorno de estresse agudo', 'Sintomas imediatos após evento traumático'
WHERE NOT EXISTS (SELECT 1 FROM condicoes_mentais WHERE condicoes_mentais_id = 21 OR condicoes_mentais_nome = 'Transtorno de estresse agudo');

INSERT INTO condicoes_mentais (condicoes_mentais_id, condicoes_mentais_nome, condicoes_mentais_descricao)
SELECT 22, 'Transtorno somatoforme', 'Sintomas físicos sem causa médica identificável'
WHERE NOT EXISTS (SELECT 1 FROM condicoes_mentais WHERE condicoes_mentais_id = 22 OR condicoes_mentais_nome = 'Transtorno somatoforme');

INSERT INTO condicoes_mentais (condicoes_mentais_id, condicoes_mentais_nome, condicoes_mentais_descricao)
SELECT 23, 'Transtorno do espectro esquizofrênico', 'Conjunto de transtornos psicóticos relacionados'
WHERE NOT EXISTS (SELECT 1 FROM condicoes_mentais WHERE condicoes_mentais_id = 23 OR condicoes_mentais_nome = 'Transtorno do espectro esquizofrênico');

INSERT INTO condicoes_mentais (condicoes_mentais_id, condicoes_mentais_nome, condicoes_mentais_descricao)
SELECT 24, 'Transtorno neurocognitivo leve', 'Comprometimento cognitivo leve'
WHERE NOT EXISTS (SELECT 1 FROM condicoes_mentais WHERE condicoes_mentais_id = 24 OR condicoes_mentais_nome = 'Transtorno neurocognitivo leve');

INSERT INTO condicoes_mentais (condicoes_mentais_id, condicoes_mentais_nome, condicoes_mentais_descricao)
SELECT 25, 'Transtorno de ansiedade social', 'Medo intenso de situações sociais'
WHERE NOT EXISTS (SELECT 1 FROM condicoes_mentais WHERE condicoes_mentais_id = 25 OR condicoes_mentais_nome = 'Transtorno de ansiedade social');

INSERT INTO condicoes_mentais (condicoes_mentais_id, condicoes_mentais_nome, condicoes_mentais_descricao)
SELECT 26, 'Transtorno do controle dos impulsos', 'Dificuldade em resistir a impulsos prejudiciais'
WHERE NOT EXISTS (SELECT 1 FROM condicoes_mentais WHERE condicoes_mentais_id = 26 OR condicoes_mentais_nome = 'Transtorno do controle dos impulsos');

INSERT INTO condicoes_mentais (condicoes_mentais_id, condicoes_mentais_nome, condicoes_mentais_descricao)
SELECT 27, 'Transtorno de personalidade narcisista', 'Necessidade de admiração e falta de empatia'
WHERE NOT EXISTS (SELECT 1 FROM condicoes_mentais WHERE condicoes_mentais_id = 27 OR condicoes_mentais_nome = 'Transtorno de personalidade narcisista');

INSERT INTO condicoes_mentais (condicoes_mentais_id, condicoes_mentais_nome, condicoes_mentais_descricao)
SELECT 28, 'Transtorno de personalidade evitativa', 'Evasão de situações sociais por medo de rejeição'
WHERE NOT EXISTS (SELECT 1 FROM condicoes_mentais WHERE condicoes_mentais_id = 28 OR condicoes_mentais_nome = 'Transtorno de personalidade evitativa');

INSERT INTO condicoes_mentais (condicoes_mentais_id, condicoes_mentais_nome, condicoes_mentais_descricao)
SELECT 29, 'Transtorno de personalidade dependente', 'Necessidade excessiva de cuidados e submissão'
WHERE NOT EXISTS (SELECT 1 FROM condicoes_mentais WHERE condicoes_mentais_id = 29 OR condicoes_mentais_nome = 'Transtorno de personalidade dependente');

INSERT INTO condicoes_mentais (condicoes_mentais_id, condicoes_mentais_nome, condicoes_mentais_descricao)
SELECT 30, 'Transtorno esquizoafetivo', 'Combinação de sintomas esquizofrênicos e de humor'
WHERE NOT EXISTS (SELECT 1 FROM condicoes_mentais WHERE condicoes_mentais_id = 30 OR condicoes_mentais_nome = 'Transtorno esquizoafetivo');
